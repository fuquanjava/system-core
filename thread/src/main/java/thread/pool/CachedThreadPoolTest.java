package thread.pool;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolTest {

    private static String now() {
        Date now = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(now);
    }

    // 默认的线程池
    static final ExecutorService service = Executors.newCachedThreadPool();


    // 使用ThreadFactory 自定义线程池
    static final ExecutorService service2 = Executors.newCachedThreadPool(new SimpleThreadFactory("cache",false));



    static class CachedTask implements Runnable {

        int i;

        public CachedTask(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.err.println(Thread.currentThread().getName() + ":" + now() + "=>" + i);
        }
    }

    public static void newCachedThreadPool() {
        for (int i = 0; i < 10; i++) {
            service2.execute(new CachedTask(i));
        }
    }


    public static void main(String[] args) {
        newCachedThreadPool();
        System.err.println("Main over!"+ now());

    }
}
