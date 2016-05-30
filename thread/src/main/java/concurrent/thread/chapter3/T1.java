package concurrent.thread.chapter3;

/**
 * Hello-World 2015/8/14 23:06
 * fuquanemail@gmail.com
 * 可见性
 */
public class T1 {
    static boolean ready =Boolean.FALSE;
    static int number;

    public static class readerThread extends Thread{
        @Override
        public void run() {
            while (!ready){
                Thread.yield();
                System.out.println(number);
            }
        }
    }
    public static void main(String[] args) {
        new T1.readerThread().start();
        ready = true;
        number =2 ;
    }
}
