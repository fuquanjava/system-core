package concurrent.thread.chapter5;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * fuquanemail@gmail.com
 */
public class FutureAndCallable {
    public static class Worker implements Callable<String> { // String 是返回结果类型
        @Override
        public String call() throws Exception {
            System.out.println("worker doing ");
            Thread.sleep(3000);
            System.out.println("worker done ");

            return "call result";
        }
    }


    public static void main(String[] args) {
        Worker worker = new Worker();
        Future<String> future = new FutureTask<String>(worker);

        try {
            worker.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
