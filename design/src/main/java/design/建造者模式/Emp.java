package design.建造者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello-World 2015/8/8 15:53
 * fuquanemail@gmail.com
 */
public class Emp {
    //需要批准的上级
    List<String> emps = new ArrayList<>();

    public void agree(String empName){
        emps.add(empName);
    }

    public void show(){
        System.out.println("emps:"+ emps.toString());
    }
}
