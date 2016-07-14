package concurrent.thread.chapter5;

/**
 * Hello-World 2015/8/23 9:12
 * fuquanemail@gmail.com
 */
public class InterruptDemo {

    public static class InterruptThread extends Thread{
        @Override
        public void run() {
            try {
                System.out.println("InterruptThread isInterrupted: "+ this.isInterrupted());
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("InterruptThread catch isInterrupted: "+ this.isInterrupted());
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        InterruptThread t1 = new InterruptThread();
        t1.start();
        t1.interrupt();
    }

}

