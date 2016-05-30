package thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * hello-world 2015/7/10 15:36
 * fuquanemail@gmail.com
 */
public class ThreadPools {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(1, 2, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 8; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            Thread.sleep(1000);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
                    executor.getQueue().size() + "，已执行玩的任务数目：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}

class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task " + taskNum);
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task " + taskNum + "执行完毕");
    }
}
