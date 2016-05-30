package concurrent.thread.chapter4;

/**
 * Hello-World 2015/8/17 22:41
 * fuquanemail@gmail.com
 */
public class T2 {
    private final Object lock = new Object();
    public void method(){
        synchronized (lock){

        }
    }
}
