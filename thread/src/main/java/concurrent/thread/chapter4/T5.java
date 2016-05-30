package concurrent.thread.chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * Hello-World 2015/8/17 23:12
 * fuquanemail@gmail.com
 */
public class T5<E> extends Vector<E> {
    public synchronized boolean putIfAbsent(E e){
        boolean absent = !contains(e);
        if(absent)
            add(e);
        return absent;
    }
}

class ListHelper<E>{
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());
/*    public synchronized boolean putIfAbsent(E e){
        boolean absent = ! list.contains(e);
        if(absent)
            list.add(e);
        return absent;
    }*/

    //改进后的方法
    public  boolean putIfAbsent(E e){
        synchronized (list) {
            boolean absent = !list.contains(e);
            if (absent)
                list.add(e);
            return absent;
        }
    }
}