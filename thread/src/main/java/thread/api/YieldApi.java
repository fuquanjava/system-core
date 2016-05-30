package thread.api;

import util.Print;

/**
 * hello.world 2015/6/14 22:01
 * fuquanemail@gmail.com
 */
public class YieldApi {
    public static void main(String[] args) {
        new Thread(new Y()).start();
        new Thread(new Y()).start();
        /**
         * 调用yield方法会让当前线程交出CPU权限，让CPU去执行其他的线程。
         * 它跟sleep方法类似，同样不会释放锁。
         * 但是yield不能控制具体的交出CPU的时间，另外，yield方法只能让拥有相同优先级的线程有获取CPU执行时间的机会。

         　　注意，调用yield方法并不会让线程进入阻塞状态，而是让线程重回就绪状态，

         它只需要等待重新获取CPU执行时间，这一点是和sleep方法不一样的。
         *
         */
    }
    static class Y implements Runnable{
        @Override
        public void run() {
            synchronized (Y.class){
                for(int i = 0 ; i< 100 ; i++){

                    if (i < 50){
                        Print.now("i="+i);
                        //让出cpu, 但不会释放锁.
                        Thread.yield();
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Print.now(" run over");
            }
        }

    }
}

