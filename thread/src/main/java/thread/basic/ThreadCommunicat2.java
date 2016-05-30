package thread.basic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * hello.world 2015/6/14 12:14
 * fuquanemail@gmail.com
 */
public class ThreadCommunicat2 {
    public static void main(String[] args) throws InterruptedException {
        Monitor monitor = new Monitor();
        // 线程1线活得锁 之后休眠2s,然后在 monitor对象上等待，并释放锁. 然后线程2再获得锁等待.
        new Thread(new C1(monitor)).start();
        new Thread(new C1(monitor)).start();
        new Thread(new C2(monitor)).start();

        // 这样会有一个问题：即当前等待的线程有可能是在notify之后才进入对象等到池中，这样的话就会丢失型号.
        // 建议增加了一个 通知信号

        //在wait()/notify()机制中，不要使用全局对象，字符串常量等。应该使用对应唯一的对象
        // 在空字符串作为锁的同步块(或者其他常量字符串)里调用wait()和notify()产生的问题是，JVM/编译器内部会把常量字符串转换成同一个对象


    }
}

class Monitor{
    // 用来存储信号
    private volatile Boolean auOk = Boolean.FALSE;

    public void setAuOk(Boolean auOk) {
        this.auOk = auOk;
    }

    public Boolean getAuOk() {
        return auOk;
    }
}

class C1 implements Runnable{
    Monitor monitor ;
    public C1(Monitor m){this.monitor = m;}
    @Override
    public void run() {
        synchronized (monitor){
            try {
                System.out.println(Thread.currentThread() + " 获得锁， c1 start wait ........" + U.printTime());
                Thread.sleep(1000);
                // if 来判断会有假唤醒的问题，改用while的话目前的JVM实现自旋会消耗CPU
//                while(! monitor.getAuOk()){
//                    monitor.wait();
//                    monitor.setAuOk(Boolean.FALSE);
//                }
                if(! monitor.getAuOk()){
                    monitor.wait();
                }
                // 改变信号
                monitor.setAuOk(Boolean.FALSE);
                System.out.println(Thread.currentThread()+" wait end ........");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()+ " 释放锁, c1 run ...");
        }
    }
}

class C2 implements Runnable{
    Monitor monitor ;
    public  C2(Monitor monitor){
        this.monitor = monitor;
    }
    @Override
    public void run() {
        System.out.println("c2 run ... 锁给我 ok :" + U.printTime());
        synchronized (monitor){
            System.out.println("c2 得到锁  ... sleep"+ U.printTime());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("c2 ... notifyAll start");
            monitor.notifyAll();
            // 改变信号
            monitor.setAuOk(Boolean.TRUE);
            System.out.println("c2 ... notifyAll end ");
            System.out.println(Thread.currentThread()+ " 释放锁, c2 run ...");
        }
    }
}

class U{
    public static String printTime(){
        long now = System.currentTimeMillis();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String nowTime = format.format(new Date(now));
        return nowTime;
    }
}