package design.工厂方法.oper;

/**
 * Hello-World 2015/8/5 22:18
 * fuquanemail@gmail.com
 */
public class OperationSub implements Operation {
    @Override
    public double getResult(double n1, double n2) {
        return n1 - n2;
    }
}
