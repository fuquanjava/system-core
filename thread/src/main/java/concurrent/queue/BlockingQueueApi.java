package concurrent.queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * fuquanemail@gmail.com 2016/6/29 16:51
 * description:
 * 1.0.0
 */
public class BlockingQueueApi {
    // LinkedBlockingQueue : 无边界队列，往队列中存放元素是不会发生阻塞的 , 为了满足无边界队列存放元素的阻塞需求，TransferQueue就应运而生
    static final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    static final TransferQueue<Integer> transferQueue = new LinkedTransferQueue<>();

    public static class ProducerTask extends Thread {
        BlockingQueue<Integer> queue;

        Random random = new Random();

        public ProducerTask(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                int num = random.nextInt();
                try {
                    System.err.println("producer num :" + num);
                    //queue.put(num);

                    // 此处阻塞，等待take()，poll()的发生, 如果没有 take(),或者 poll(), 该方法一直阻塞
                    transferQueue.transfer(num);
                    System.err.println("producer num  ok :" + num);
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class ConsumerTask extends Thread {
        BlockingQueue<Integer> queue;

        public ConsumerTask(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Integer num = 0;
                    //num = queue.poll();
                    //num = transferQueue.take();

                    System.err.println("consumer num :" + num);
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        ProducerTask producerTask = new ProducerTask(queue);
        ConsumerTask consumerTask = new ConsumerTask(queue);

        producerTask.start();

        consumerTask.start();
    }
}
