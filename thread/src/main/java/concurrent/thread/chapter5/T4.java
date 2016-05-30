package concurrent.thread.chapter5;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Hello-World 2015/8/23 11:04
 * fuquanemail@gmail.com
 */
public class T4<T> {
    private final Set<T> set;
    private final Semaphore semaphore;
    public T4(int bound){
        this.set = Collections.synchronizedSet(new HashSet<T>());
        this.semaphore = new Semaphore(bound);
    }
    public boolean add(T t ) throws InterruptedException{
        semaphore.acquire();
        boolean wasAdded = false;
        try {
            wasAdded = set.add(t);
            return wasAdded;
        }finally {
            if(! wasAdded){
                semaphore.release();
            }
        }
    }
}
