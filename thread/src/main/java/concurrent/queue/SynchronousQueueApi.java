package concurrent.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * fuquanemail@gmail.com
 */
public class SynchronousQueueApi {
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
                    // 往queue放进去一个element以后就一直wait直到有其他thread进来把这个element取走。
                    queue.put(i++);
                    // offer:queue里放一个element后立即返回，如果碰巧这个element被另一个thread取走了，
                    // offer方法返回true，认为offer成功；否则返回false。
                    queue.offer(i++);
                    System.out.println("producer put:"+i);

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
                    System.out.println("consumer:"+ i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    queue.clear();
                }
            }

        }
    }

    public static void main(String[] args) {
        final BlockingQueue queue = new SynchronousQueue(true);
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
