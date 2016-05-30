package thread.api;

/**
 * hello-world
 * 2015/9/22 16:17
 */
public class WaitDemo {
    public static class WaitThread extends Thread{
        public  void run() {
            synchronized (this){
                try {
                    System.out.println("WaitThread 开始 等待 ...");
                    this.wait(); //在WaitThread实例上等待.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class NotifyThread extends Thread{
        WaitThread waitThread;
        public NotifyThread(WaitThread waitThread){
            this.waitThread =  waitThread;
        }
        public  void run() {
            synchronized (waitThread){
                System.out.println("唤醒 WaitThread . waiting");
                waitThread.notify();//唤醒在waitThread实例上的某个等待
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        WaitThread waitThread = new WaitThread();
        waitThread.start();
        Thread.sleep(30000);
        NotifyThread notifyThread = new NotifyThread(waitThread);
        notifyThread.start();

    }
}
