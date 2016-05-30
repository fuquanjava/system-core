package concurrent.thread.chapter7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello-World 2015/9/13 15:07
 * fuquanemail@gmail.com
 */
public class T6 {
    private final ExecutorService exec = Executors.newSingleThreadExecutor();
    public void start(){}
    public void stop(){
        try {
            exec.shutdown();

        }catch (Exception e){
        }finally {
            //其他关闭
        }
    }
}
