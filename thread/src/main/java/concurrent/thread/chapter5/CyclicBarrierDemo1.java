package concurrent.thread.chapter5;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * hello-world
 * 2015/9/22 11:51
 */
public class CyclicBarrierDemo1 {
    static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
    static class CyclicThread extends Thread{
        @Override
        public void run() {
            try {
                Print.now("等待");
                cyclicBarrier.await();
                Print.now("执行完毕");



            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        int n = cyclicBarrier.getParties();
        System.out.println("barrier 的参与者数目:"+n);
        for(int i=0; i<n ;i++) {
            CyclicThread cyclicThread = new CyclicThread();
            cyclicThread.start();
            Thread.sleep(1000);
            //在栅栏上等待的线程
            System.out.println("等待的参与者数目:"+cyclicBarrier.getNumberWaiting());
        }



    }
}
