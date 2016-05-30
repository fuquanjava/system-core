package design.建造者模式;

import design.建造者模式.dept.Emp1;

/**
 * Hello-World 2015/8/8 16:02
 * fuquanemail@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        Ask4leaveBuilder builder = new Emp1();
        director.contruct(builder);

        builder.getEmp().show();

        // 此时，如果有新的部门，只需要实现Ask4leaveBuilder接口即可.流程不会变.
    }
}
