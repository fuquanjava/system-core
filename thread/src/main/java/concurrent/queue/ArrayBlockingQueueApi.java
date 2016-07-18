package concurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * fuquanemail@gmail.com
 */
public class ArrayBlockingQueueApi {
    public static class Producer extends Thread {
        private BlockingQueue<Integer> queue;

        public Producer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            int i = 1;
            while (true) {
                try {
                    queue.put(i++);
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    queue.clear();
                }
            }
        }
    }

    public static class Consumer extends Thread {
        private BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    int i = queue.take();
                    System.out.println(i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    queue.clear();
                }
            }

        }
    }

    public static void main(String[] args) {
        final BlockingQueue queue = new ArrayBlockingQueue(10);
        Producer p1 = new Producer(queue);
        Consumer c1 = new Consumer(queue);

        p1.start();
        c1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int size = queue.size();
                    System.out.println("queue size:" + size);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
