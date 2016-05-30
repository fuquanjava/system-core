package design.简单工厂;

import design.简单工厂.oper.Operation;

/**
 * Hello-World 2015/8/5 22:29
 * fuquanemail@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        Operation operation = OperationFactory.createOperation(OperationFactory.ADD);
        double n1 = 1;
        double n2 = 2;
        System.out.println(operation.getResult(n1 , n2));

    }
}
