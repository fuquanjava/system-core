package thread.basic;

/**
 * fuquanemail@gmail.com 2016/6/7 10:00
 * description:
 * 1.0.0
 */
public class ThreadInJvm {
    public static class MyThread extends Thread {
        String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                System.err.println("i'm: " + name);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MyThread myThread = new MyThread("00" + i);
            myThread.start();
        }
    }
}
