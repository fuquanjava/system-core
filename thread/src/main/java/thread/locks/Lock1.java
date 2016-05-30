package thread.locks;

/**
 * hello.world 2015/6/14 16:00
 * fuquanemail@gmail.com
 */
public class Lock1 {
    public static void main(String[] args) {
        /**
         * Java中的synchronized同步块是可重入的, 意味能进入outer方法 就能进入 inner方法.
         * 一个线程已经拥有了一个管程对象上的锁，那么它就有权访问被这个管程对象同步的所有代码块
         *
         * 但是 用我们的lock 来写是否可行？
         *
         * public synchronized outer(){
                inner();
            }
         *  public synchronized inner(){
                do something
            }
         *
         */

    }
}

class A{
    private long count = 0;
    MyLock lock = new MyLock();
    public void inc(){
        synchronized (this){
            count ++;
        }
    }
    // 利用 自定义Lock 来实现.
    public void inc2() throws InterruptedException {
        lock.lock();
        count++;
        lock.unLock();
    }
    // 有问题？ 有
    // inner()方法中该线程将再一次尝试锁住Lock实例，结果该动作会失败（也就是说该线程会被阻塞），因为这个Lock实例已经在outer()方法中被锁住了
    // 两次lock()之间没有调用unlock()，第二次调用lock就会阻塞 . 咋搞？ 优化 MyLock-> MyNBLock
    public void outer() throws InterruptedException {
        lock.lock();
        inner();
        lock.unLock();
    }

    private void inner() throws InterruptedException {
        lock.lock();
        System.out.println("fuck .");
        lock.unLock();
    }
}

class MyLock{
    private Boolean isLock = Boolean.FALSE;
    public synchronized void lock() throws InterruptedException {
        while(isLock){
            this.wait();
        }
        isLock=Boolean.TRUE;

    }
    public synchronized void unLock(){
        //先修改符号信号 , 再来唤醒等待的线程
        isLock = Boolean.FALSE;
        notify();
    }
}

class MyNBLock{
    private Boolean isLock=Boolean.FALSE;
    Thread lockBy = null;
    int lockCount = 0;

    public synchronized void lock() throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        while(isLock && ! currentThread.equals(lockBy)){
            this.wait();
        }
        isLock = Boolean.TRUE;
        lockCount++;
        lockBy =  currentThread;


    }
    public synchronized void unLock(){
        Thread currentThread = Thread.currentThread();
        // 除此之外，我们需要记录同一个线程重复对一个锁对象加锁的次数。
        // 否则，一次unblock()调用就会解除整个锁，即使当前锁已经被加锁过多次。
        // 在unlock()调用没有达到对应lock()调用的次数之前，我们不希望锁被解除。

//        现在这个Lock类就是可重入的了
        if(currentThread.equals(lockBy)){
            lockCount --;
            if(lockCount == 0){
                isLock = Boolean.FALSE;
                notify();
            }
        }


    }
}
