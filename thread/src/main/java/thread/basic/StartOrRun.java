package thread.basic;

/**
 * hello-world
 * 2015/9/22 16:00
 */
public class StartOrRun extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StartOrRun startOrRun = new StartOrRun();
//        startOrRun.run();
        startOrRun.start();
        int i = 1 +1;
        System.out.println("启动完毕.");

    }
}
