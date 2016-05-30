package concurrent.thread.chapter5;

/**
 * Hello-World 2015/8/23 9:12
 * fuquanemail@gmail.com
 */
public class T2 {
    public static Thread process(){
        System.out.println(" t 准备启动");
        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        System.out.println(" t 已经启动");
        return t;

    }
    public static void main(String[] args) {
        Thread t = T2.process();
        t.interrupt();

        System.out.println("执行完毕");
    }

}

