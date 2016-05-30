package concurrent.thread.chapter4;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Hello-World 2015/8/17 22:58
 * fuquanemail@gmail.com
 */
public class T4 {
    // lower <= upper
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    public void setLower(int n){
        //注意 不安全的“先检查后执行"
        if( n > upper.get()){
            throw new IllegalArgumentException("参数异常");
        }
        lower.set(n);
    }

    public void setUpper(int i) {
        //注意 不安全的“先检查后执行"
        if( i < lower.get()){
            throw new IllegalArgumentException("参数异常");
        }
        upper.set(i);
    }
}
