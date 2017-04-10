package thread.pool;


import java.util.Date;
import java.util.concurrent.*;

public class ThreadPoolTest {

    public static void main(String[] args) {
        newCachedThreadPool();

    }

    public static void newCachedThreadPool() {
        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            service.execute(new CachedTask(i));
        }


    }

    static class CachedTask implements Runnable {

        int i;

        CachedTask(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            Date date = new Date();
            System.err.println(this.i + ":" + name + ":" + date);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
