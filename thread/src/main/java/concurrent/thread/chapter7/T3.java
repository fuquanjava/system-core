package concurrent.thread.chapter7;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Hello-World 2015/9/10 7:30
 * fuquanemail@gmail.com
 */
public class T3 {
    private static final ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
    public static void timedRun(Runnable runnable, long timeOut, TimeUnit unit){
        final Thread task = Thread.currentThread();
        exec.schedule(new Runnable() {
            @Override
            public void run() {
                task.interrupt();
            }
        }, timeOut, unit);
        runnable.run();
    }

    public static void main(String[] args) {
        T33 t33 = new T33();
        T3.timedRun(t33,3,TimeUnit.SECONDS);
    }
}

class T33 extends Thread{
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("11111111");
        }


    }
}

