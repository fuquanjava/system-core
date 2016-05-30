package thread.api;

/**
 * hello-world
 * 2015/9/23 17:06
 */
public class WaitDemo3 {
    public static final Object obj = new Object();

    public static class WaitThread extends Thread{
        public WaitThread(String name){
            this.setName(name);
        }
        public  void run() {
            synchronized (obj){
                try {
                    System.out.println(this.getName()+"开始等待");
                    obj.wait();
                    System.out.println(this.getName()+"被唤醒了...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class NotifyThread extends Thread{
        public  void run() {
            synchronized (obj){
                // obj.notify(); //随机唤醒1个线程
                obj.notifyAll(); //全部
                System.out.println("还不能开始执行，因为还没有释放锁");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<10; i++){
            WaitThread waitThread = new WaitThread("线程:"+i);
            waitThread.start();
        }
        Thread.sleep(1000);
        /*for(int i=0;i<10; i++){
            NotifyThread notifyThread = new NotifyThread();
            notifyThread.start();
            Thread.sleep(1000);
        }
*/
        NotifyThread notifyThread = new NotifyThread();
        notifyThread.start();
    }
}
