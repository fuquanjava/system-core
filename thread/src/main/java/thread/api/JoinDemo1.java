package thread.api;

/**
 * hello-world
 * 2015/9/23 18:02
 */
public class JoinDemo1 {
    static class T1 extends Thread{
        public void run() {
            try {
                System.out.println(this.getName()+"开始执行...");
                Thread.sleep(3000);
                System.out.println(this.getName() + "执行完毕...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.start();
        t1.join(); // 当前线程在t1上等待,等待t1执行完毕

        System.out.println(Thread.currentThread().getName() + "执行完毕...");



    }
}
