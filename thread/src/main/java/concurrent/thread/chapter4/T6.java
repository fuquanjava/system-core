package concurrent.thread.chapter4;

import java.util.List;

/**
 * Hello-World 2015/8/17 23:22
 * fuquanemail@gmail.com
 */
public class T6<E> {
    private final List<E> list;

    public T6(List<E> list) {
        this.list = list;
    }
    public synchronized boolean putIfAbsent(E e){
        boolean absent = ! list.contains(e);
        if(absent)
            list.add(e);
        return absent;
    }
}
