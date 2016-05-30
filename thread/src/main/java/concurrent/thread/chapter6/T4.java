package concurrent.thread.chapter6;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Hello-World 2015/8/26 7:21
 * fuquanemail@gmail.com
 */
public class T4 {
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    // throw new RuntimeException("ex");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Timer timer = new Timer("timer");
        timer.schedule(task, 1000,1000);
    }
}
