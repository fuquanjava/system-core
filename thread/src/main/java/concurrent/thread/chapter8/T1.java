package concurrent.thread.chapter8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Hello-World 2015/9/13 20:31
 * fuquanemail@gmail.com
 */
public class T1 {
    static ExecutorService service = Executors.newCachedThreadPool();
    static class Task implements Callable<String>{
        @Override
        public String call() throws Exception {
            Future<String> future =  service.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("return aaa");
                    return "aaa";
                }
            });
            System.out.println("return method");
            //return future.get();
            return "aa";
        }
    }

    public static void main(String[] args) {

        Task task = new Task();
        service.submit(task);
        System.out.println("main");
    }
}
