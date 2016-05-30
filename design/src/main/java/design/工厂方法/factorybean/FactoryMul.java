package design.工厂方法.factorybean;

import design.工厂方法.IFactory;
import design.工厂方法.oper.Operation;

/**
 * Hello-World 2015/8/9 16:39
 * fuquanemail@gmail.com
 */
public class FactoryMul implements IFactory {
    @Override
    public Operation getoperation() {
        return new design.工厂方法.oper.OperationMul();
    }
}
