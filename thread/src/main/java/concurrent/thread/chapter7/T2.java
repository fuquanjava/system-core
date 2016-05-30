package concurrent.thread.chapter7;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Hello-World 2015/9/5 11:26
 * fuquanemail@gmail.com
 */
public class T2 {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);
    private static volatile boolean isCancel = Boolean.FALSE;
    static class T22 extends Thread{
        public void run() {
            int i = 0;
            while (! Thread.currentThread().isInterrupted()){
                System.out.println(Thread.interrupted());
                System.out.println(Thread.currentThread().isInterrupted());
                try {
                    queue.put(i++);
                    System.out.println(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程执行完毕...");
        }

        public void setCancel() {
            interrupt();
        }
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        T22 t22 = new T22();
        t22.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //t2.setIsCancel();
            t22.setCancel();

        }


    }
}
