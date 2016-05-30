package thread.basic;

/**
 * hello.world 2015/6/14 10:29
 * fuquanemail@gmail.com
 */
public class SynchThread implements Runnable {
    Koo koo;
    public SynchThread(Koo koo){
        this.koo = koo;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 当 10 传递给koo的count时，没有立即写入内存，而是缓存在cpu的寄存器或者cpu的内存中.
        // 导致对其他线程不可见. 并不会按照期望的结果出现
        koo.add(10);
        koo.add2(10);
        koo.add3(10);

    }
    public static void main(String[] args) throws InterruptedException {
        Koo k = new Koo();
        for(int i = 0 ; i < 100 ; i++){
            new Thread(new SynchThread(k)).start();
        }
        // 为什么要休眠？不休眠有可能Main线程获取值的时候 ，线程还没执行完
        Thread.sleep(1000);
        System.out.println(Thread.currentThread()+",count = "+k.count);
        System.out.println(Thread.currentThread()+",sum = "+ k.sum);
        System.out.println(Thread.currentThread()+",s = "+ k.sum);

    }


}

class Koo {
    long count = 0;
    long sum = 0;
    // volatile能保证每次都是从 RAM中获取数据操作并回写，不会缓存在CPU的cache中
    volatile  long s = 0;
    public  void add(int n) {
        this.count += n;

    }
    public synchronized void add2(int n ){
        this.sum += n;
    }
    public void add3(int i){
        this.s +=i;
    }
}

