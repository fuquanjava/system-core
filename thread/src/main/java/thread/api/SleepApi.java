package thread.api;

import util.Print;

/**
 * hello.world 2015/6/14 17:51
 * fuquanemail@gmail.com
 */
public class SleepApi {
    public static void main(String[] args) {
        new Thread(new S()).start();
        new Thread(new S()).start();
        new Thread(new S()).start();
        /**
         * 　sleep相当于让线程睡眠，交出CPU，让CPU去执行其他的任务
         *   但是有一点要非常注意，sleep方法不会释放锁，也就是说如果当前线程持有对某个对象的锁，则即使调用sleep方法，其他线程也无法访问这个对象。
         *
         *   sleep 方法当线程睡眠时间满后，不一定会立即得到执行，因为此时可能CPU正在执行其他的任务。
         *
         *   所以说调用sleep方法相当于让线程进入阻塞状态。
         */

    }
    static class S implements Runnable{

        @Override
        public void run() {
            synchronized (S.class) {
                Print.now("start sleep ");
                try {
                    // 3s
                    Thread.sleep(3000000);
                    // 3s  , 500 纳秒
//                Thread.sleep(3000 , 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Print.now(" run over ");
            }
        }
    }

}
