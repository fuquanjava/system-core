package concurrent.thread.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * hello-world
 * 2015/9/18 10:04
 */
public class ListDemo1 {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {

        AddThread add  = new AddThread();
        PrintThread print = new PrintThread();

        add.start();
        print.start();

    }
    static class AddThread extends Thread{
        @Override
        public void run() {
            Random random = new Random();
            while (true){
                list.add(random.nextInt(Integer.MAX_VALUE));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    static class PrintThread extends Thread{
        @Override
        public void run() {
            while (true){
                // 这里会抛出异常
                System.out.println(list);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
