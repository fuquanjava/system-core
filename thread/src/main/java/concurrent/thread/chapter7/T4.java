package concurrent.thread.chapter7;

import java.util.concurrent.*;

/**
 * Hello-World 2015/9/13 10:53
 * fuquanemail@gmail.com
 */
public class T4 {
    static final ExecutorService service = new ScheduledThreadPoolExecutor(1);
    public static void timedRun(Runnable runnable, long timeOut, TimeUnit timeUnit){
        Future<?> task = service.submit(runnable);
        try {
            task.get();
        } catch (InterruptedException e) {
            // task.cancel(true); 任务取消，直接写在finally中
        } catch (ExecutionException e) {
            throw new RuntimeException(e.getCause());
        }finally {
            //如果任务结束，取消操作不会有任何影响
            //如果正在执行，那么将会被中断
            task.cancel(true);
        }

    }
}
