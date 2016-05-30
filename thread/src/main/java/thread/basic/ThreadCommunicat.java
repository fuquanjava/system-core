package thread.basic;

/**
 * hello.world 2015/6/14 11:30
 * fuquanemail@gmail.com
 */
public class ThreadCommunicat {
    public static void main(String[] args) {
        // 通过共享对象通信 , 线程间发送信号的一个简单方式是在共享对象的变量里设置信号值
        // 两个线程必须是同一个对象实例，否则获取不到信号值 (忙等待)
        // 忙等待没有对运行等待线程的CPU进行有效的利用，除非平均等待时间非常短。
        // 否则，让等待线程进入睡眠或者非运行状态更为明智，直到它接收到它等待的信号。
        A a = new A();
        new Thread(new T1(a)).start();
        new Thread(new T2(a)).start();

        /**
         *
         * java有一个内建的等待机制来允许线程在等待信号的时候变为非运行状态。
         *
         * java.lang.Object 类定义了三个方法，wait()、notify()和notifyAll()来实现这个等待机制。

           一个线程一旦调用了任意对象的wait()方法，就会变为非运行状态，直到另一个线程调用了同一个对象的notify()方法。
           为了调用wait()或者notify()，线程必须先获得那个对象的锁。

         也就是说，线程必须在同步块里调用wait()或者notify()。
         *
         */
    }

}

class A{
    private boolean isOK = false;
    public synchronized boolean isOK(){
        return isOK;
    }
    public synchronized void setOK(boolean isOk) {
        this.isOK = isOk;
    }
}

class T1 implements Runnable{
    A a ;
    public T1(A a){
        this.a = a;
    }
    @Override
    public void run() {
        int i = 0;
        while (i<10) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ping ... "+ i);
            i++;
        }
        a.setOK(true);
    }
}

class T2 implements Runnable{
    A a ;
    public T2(A a){
        this.a = a;
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("zzz .........");

            if(a.isOK()){
                System.out.println( " is ok ......  go ");
                break;
            }
        }
    }
}