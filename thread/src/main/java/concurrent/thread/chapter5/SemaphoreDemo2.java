package concurrent.thread.chapter5;



import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * hello-world
 * 2015/9/22 10:07
 * 模拟数据库连接池
 */
public class SemaphoreDemo2 {
    private static final Semaphore pool = new Semaphore(5);

    static class ConnThread extends Thread{
        @Override
        public void run() {
            try {
                boolean conn = pool.tryAcquire(2, TimeUnit.SECONDS);
                if(conn){
                    Print.now("执行SQL");
                    Thread.sleep(3000);
                    pool.release();
                }else{
                    Print.now("不能获取链接");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(pool.availablePermits());
        for(int i=0; i<10 ; i++){
            new ConnThread().start();
        }


    }
}
