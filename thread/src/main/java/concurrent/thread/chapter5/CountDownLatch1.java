package concurrent.thread.chapter5;

import java.util.concurrent.CountDownLatch;

/**
 * hello-world
 * 2015/9/21 17:14
 */
public class CountDownLatch1 {
    private static Integer MAX_THREAD_NUMS = 5;
    static final CountDownLatch latch = new CountDownLatch(5);
    static class CThread extends  Thread{
        private int i ;
        public CThread(int i){
            this.i = i;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程:" + i);
            latch.countDown();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        //System.out.println("锁计数器:"+latch.getCount());
        for(int i = 0 ; i< MAX_THREAD_NUMS; i++){
            CThread c = new CThread(i);
            c.start();
        }
        latch.await();
        System.out.println("主线程执行完毕.");
    }
}
