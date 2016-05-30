package design.建造者模式.dept;

import design.建造者模式.Ask4leaveBuilder;
import design.建造者模式.Emp;

/**
 * Hello-World 2015/8/8 15:57
 * fuquanemail@gmail.com
 */
public class Emp1 extends Ask4leaveBuilder {
    private Emp emp = new Emp();
    @Override
    public void ask1() {
        emp.agree("emp1 1");
    }

    @Override
    public void ask2() {
        emp.agree("emp1 2");
    }

    @Override
    public void ask3() {
        emp.agree("emp1 3");
    }

    @Override
    public Emp getEmp() {
        return emp;
    }
}
