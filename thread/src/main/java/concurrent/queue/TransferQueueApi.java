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
public class TransferQueueApi {
    // LinkedBlockingQueue : 默认队列的大小是 Integer.MAX_VALUE ， 所以称之为 无边界队列，往队列中存放元素是不会发生阻塞的。
    static final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    // TransferQueue:生产者会一直阻塞直到所添加到队列的元素被某一个消费者所消费（不仅仅是添加到队列里就完事）
    static final TransferQueue<Integer> transferQueue = new LinkedTransferQueue<>();

    private static int queueSize = 10;

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
                    //queue.put(num);

                    // 此处阻塞，等待take()，poll()的发生, 如果没有 take(),或者 poll(), 该方法一直阻塞
                    //transferQueue.transfer(num);

                    // 插入一个元素到队列的尾部，As the queue is unbounded, this method will never block.
                    //transferQueue.put(num);

                    if (! transferQueue.tryTransfer(num)){
                        if(transferQueue.size() < queueSize){
                            transferQueue.put(num);
                            System.err.println("producer put num  ok :" + num);
                        }else {
                            transferQueue.transfer(num);
                            System.err.println("producer transfer num  ok :" + num);
                        }
                    }


                    Thread.sleep(500);
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
                    num = transferQueue.poll();

                    System.err.println("consumer num :" + num);
                    Thread.sleep(3000);

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

       // consumerTask.start();
    }
}
