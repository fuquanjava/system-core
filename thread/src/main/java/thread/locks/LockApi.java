package thread.locks;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * hello.world 2015/6/15 22:33
 * fuquanemail@gmail.com
 */
public class LockApi {
    public static void main(String[] args) {
        LL l = new LL();
        Lock lock = new ReentrantLock(true); //公平的可重入锁
        new Thread(new L(l, lock)).start();
        new Thread(new L(l, lock)).start();
        new Thread(new L(l, lock)).start();


    }
}

class L implements Runnable {
    LL l;
    // 默认创建非公平 可重入锁
//    Lock lock = new ReentrantLock();
//    这么写的锁是没有用的,每个线程都有自己的lock实例。解决办法：全局或者构造传入

    Lock lock;

    public L(LL l, Lock lock) {
        this.l = l;
        this.lock = lock;
    }

    /*@Override
    public void run() {
        try {
            lock.lock();
            Print.now(" 获得锁 , 开始计算");
            for (int i = 0; i < 100; i++) {
                l.add(i);
            }
        } catch (Exception e) {
        } finally {
            Print.now(" 释放锁 , l= "+l.l);
            lock.unlock();
        }
    }*/

    // 演示trylock
    public void run() {
        if (lock.tryLock()) {
            try {

                //Print.now("得到锁,开始sleep");
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }else {
           // Print.now(" 得 锁失败了 ..");
        }

    }
}

class LL {
    long l = 0;

    public void add(int n) {
        this.l += n;
    }
}
