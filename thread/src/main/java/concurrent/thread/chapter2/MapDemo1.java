package concurrent.thread.chapter2;

import java.util.LinkedHashMap;

/**
 * hello-world
 * 2015/9/21 14:28
 */
public class MapDemo1 {
    public static void main(String[] args) {
        f1();
    }

    private static void f1() {
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>(10,0.75F,true);
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);

        System.out.println(map);
    }
}
