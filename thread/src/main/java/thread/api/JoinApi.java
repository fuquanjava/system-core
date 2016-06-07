package thread.api;


/**
 * hello.world 2015/6/14 22:08
 * fuquanemail@gmail.com
 */
public class JoinApi {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new J());
        t.start();

//        join() : 等待join线程执行完毕.
//        join(long millis)     //等待 参数为毫秒
//        join(long millis,int nanoseconds)    //等待 第一参数为毫秒，第二个参数为纳秒

        t.join(); //让当前线程等待
//        t.start(); 不能在后面启动，失效.
        //Print.now(" main 线程");
        /**
         *join方法是调用了Object的wait方法
         * wait方法会让线程进入阻塞状态，并且会释放线程占有的锁，并交出CPU执行权限。
         　由于wait方法会让线程释放对象锁，所以join方法同样会让线程释放对一个对象持有的锁
         *
         *
         */

    }
    static class J implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Print.now(" over ....");
        }
    }
}
