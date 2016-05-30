package thread.readwritelock;

import util.Print;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * hello.world 2015/6/15 23:06
 * fuquanemail@gmail.com
 */
public class Lock1 implements Runnable {
    D d ;
    public  Lock1(D d){
        this.d  = d;
    }
    public static void main(String[] args) {
        D d = new D();
        new Thread(new Lock1(d)).start();
        new Thread(new Lock1(d)).start();
    }

    @Override
    public void run() {
        for(int i = 0 ; i<10; i++){
            d.add(i);
            d.print();
        }
    }
}

class D{
    long sum = 0;
    // 结果：必须先执行写操作，写操作再耗时 ，也必须执行完.
//    Lock lock  = new ReentrantLock(true);
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void add(int i){
        try {
//            lock.lock();
            lock.writeLock();
            Thread.sleep(3000);
            this.sum += i;
            Print.now(" 执行######## 写 ############ 操作: sum= "+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }

    }
    public void print(){
        try {
//            lock.lock();
            lock.readLock();
            Print.now(" 执行 读 操作: sum= "+sum);
        }finally {
//            lock.unlock();
            lock.readLock().unlock();
        }
    }

}