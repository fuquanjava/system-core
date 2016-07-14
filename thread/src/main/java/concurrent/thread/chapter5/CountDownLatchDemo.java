package concurrent.thread.chapter5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * hello-world
 * 2015/9/21 17:14
 * 将一个问题分成 N 个部分，用执行每个部分并让锁存器倒计数的 Runnable 来描述每个部分，然后将所有 Runnable 加入到 Executor 队列。
 * 当所有的子部分完成后，协调线程就能够通过 await
 *
 * 目的的是 等待所有的线程全部执行完
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch doneSignal = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(5); // 5 个大小固定的 线程池
        System.out.println("count:" + doneSignal.getCount());

        for (int i = 0; i < 3; i++) {
            executor.execute(new Worker(doneSignal, i));
        }
        try {
            System.out.println(" start await ");
            // 使当前线程在锁存器倒计数至零之前一直等待，除非线程被 中断或超出了指定的等待时间。
            doneSignal.await();           // wait for all to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" await over");
        executor.shutdown();

    }

    public static class Worker extends Thread {
        private final CountDownLatch doneSignal;
        private final int i;

        public Worker(CountDownLatch doneSignal, int i) {
            this.doneSignal = doneSignal;
            this.i = i;
        }

        @Override
        public void run() {
            doWork(i);
            doneSignal.countDown(); // 递减锁存器的计数，如果计数到达零，则释放所有等待的线程 , releaseShared(1)
            System.out.println(i + " do work over ");
        }

        private void doWork(int i) {
            try {
                System.out.println(i + " do work start ");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
