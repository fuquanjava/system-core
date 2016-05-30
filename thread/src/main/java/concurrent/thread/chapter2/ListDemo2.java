package concurrent.thread.chapter2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * hello-world
 * 2015/9/21 16:33
 */
public class ListDemo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Iterator<String> itn = list.iterator();
        while (itn.hasNext()){
            String s = itn.next();
        }

        for(String s : list){
            String s2 = s;
        }
    }
}
