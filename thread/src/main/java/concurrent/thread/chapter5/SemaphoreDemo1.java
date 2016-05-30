package concurrent.thread.chapter5;

import java.util.concurrent.Semaphore;

/**
 * hello-world
 * 2015/9/22 9:58
 */
public class SemaphoreDemo1 {
//     5个许可，非公平的
    private static final Semaphore semaphore = new Semaphore(5);
    private static final int WORKER_NUM = 10;
//    5个许可，公平的
//    private static final Semaphore s = new Semaphore(5 , true);
    static class Worker extends Thread{
        private int num;
        public Worker(int num){
            this.num = num;
        }
        public void run() {
            try {
                // semaphore.acquire();
                //获取5个许可，释放的时候要释放相同数量的许可，否则许可占满了，其他线程获得不了许可.
                semaphore.acquire(5);
                System.out.println("工人"+this.num+"占用一个机器在生产...");
                Thread.sleep(3000);
                System.out.println("工人"+this.num+"释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        for(int i= 0; i< WORKER_NUM ;i++){
            Thread.sleep(1000);
            new Worker(i).start();
        }
    }
}
