package thread.api;

/**
 * hello-world
 * 2015/9/24 10:23
 */
public class InterruptDemo {
    static class InterruptThread extends Thread{
        public void run() {
            /*while (true){
                System.out.println("isAlive:"+isAlive()); // true
                System.out.println("isInterrupted:"+isInterrupted()); // false
                System.out.println("isDaemon:"+isDaemon()); // false
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/

            int i = 1;
            while (! isInterrupted()){
                i++;
            }
            System.out.println("isInterrupted:"+isInterrupted());
            System.out.println("isAlive:"+isAlive());
        }
    }

    static class InterruptThread2 extends Thread{
        public void run() {
            while (true){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println("isInterrupted:" + isInterrupted());
                    System.out.println("isAlive:" + isAlive());
                    e.printStackTrace();
                    break; //注意这里的break
                }
            }

        }
    }


    public static void main(String[] args) {
        InterruptThread2 interruptThread = new InterruptThread2();
        interruptThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        interruptThread.interrupt();
    }
}
