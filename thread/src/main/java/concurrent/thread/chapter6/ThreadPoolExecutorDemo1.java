package concurrent.thread.chapter6;

import java.util.concurrent.*;

/**
 * fuquanemail@gmail.com
 */
public class ThreadPoolExecutorDemo1 {
    public static void main(String[] args) {
        int corePoolSize = 1;
        int maximumPoolSize = 2;
        long keepAliveTime = 1000 * 10;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(10);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                keepAliveTime, unit, workQueue);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(" ThreadPoolExecutor execute");
            }
        });

        Future<?> future = executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("ThreadPoolExecutor submit");
            }
        });


    }
}
