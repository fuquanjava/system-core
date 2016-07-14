package concurrent.thread.chapter5;

import java.util.concurrent.CountDownLatch;

/**
 * fuquanemail@gmail.com
 * <p/>
 * 所有的线程等待 同时执行
 */
public class CountDownLatchDemo2 {
    public static class Worker extends Thread {
        int i;
        public Worker(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(i +" run start ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i +" run end");

        }
    }


    public static void main(String[] args) throws InterruptedException {


        timeTasks(3, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() +" run start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +" run over");

            }
        });

    }

    public static long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        // 初始化一个计数器,计数器初始化为一个正数，表示需要等待的时间数量
        // 将计数 1 初始化的 CountDownLatch 用作一个简单的开/关锁存器
        final CountDownLatch startGate = new CountDownLatch(1);

        final CountDownLatch endGate = new CountDownLatch(nThreads);


        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        // 等待计数器到达零,表示所有需要等待的事件都已发生过
                        // 如果计数器的值非零，那么await会一阻塞直到计数器为零
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            //递减计数器，表示有一个事件已经发生了
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }
}
