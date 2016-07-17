package concurrent.thread.chapter7;

/**
 * fuquanemail@gmail.com
 */
public class ThreadStop {

    private static int a, b;
    public static boolean changeA = false;

    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();

        t1.start();
        t2.start();

        while (true) {
            System.out.println("t1 stop");
            if (changeA) {
                // t1.stop();
                t1.suspend();
                break;
            }
        }
    }

    public static class T1 extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (ThreadStop.class) {
                    a++;
                    changeA = true;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b++;
                }
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (ThreadStop.class) {
                    System.out.println("a=" + a + ",b=" + b);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
