package design.简单工厂;

import design.简单工厂.oper.*;

/**
 * Hello-World 2015/8/5 22:14
 * fuquanemail@gmail.com
 */
public class OperationFactory {
    public static final String ADD = "+";
    public static final String SUB = "-";
    public static final String MUL = "*";
    public static final String DIV = "/";

    public static Operation createOperation(String operType){
        Operation operation = null;
        switch (operType) {
            case ADD:
                operation = new OperationAdd();
                break;
            case SUB:
                operation = new OperationSub();
                break;
            case MUL:
                operation = new OperationMul();
                break;
            case DIV:
                operation = new OperationDiv();
                break;
            default:operation = new OperationAdd();

        }

        return operation;
    }
}
