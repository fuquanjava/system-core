package design.工厂方法;

import design.工厂方法.factorybean.FactoryAdd;
import design.工厂方法.oper.Operation;

/**
 * Hello-World 2015/8/8 14:11
 * fuquanemail@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        //以后想要新增算法 ，只需要
        // 1. 新增功能类.
        // 2.实现 IFactory
        // 3. 修改客户端代码
        IFactory bean = new FactoryAdd();
        Operation operation = bean.getoperation();
        System.out.println(operation.getResult(1, 2));




    }
}
