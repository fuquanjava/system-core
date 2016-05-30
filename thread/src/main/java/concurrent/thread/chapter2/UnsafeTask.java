package concurrent.thread.chapter2;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * hello-world
 * 2015/9/16 15:02
 */
public class UnsafeTask implements Runnable {
    private Date startDate;

    public void run() {
        startDate = new Date();
        System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate);
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("=============Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate);
    }

    public static void main(String[] args) {
        UnsafeTask task = new UnsafeTask();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
