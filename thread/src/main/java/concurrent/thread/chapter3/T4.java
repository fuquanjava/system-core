package concurrent.thread.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello-World 2015/8/15 0:15
 * fuquanemail@gmail.com
 */
public class T4 {
    // list不可变. 属性final
    private final List<String> list = new ArrayList<>();
    private String str = "a"; //不可变属性.外面不能修改
    public T4(){
        list.add("1");
    }
}
