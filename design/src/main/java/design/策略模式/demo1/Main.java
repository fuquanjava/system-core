package design.策略模式.demo1;

import design.策略模式.demo1.impl.CalcStrategyA;

/**
 * Hello-World 2015/8/5 22:47
 * fuquanemail@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        CalcStrategy cA = new CalcStrategyA();

        StrategyContext context = new StrategyContext(cA);

        long price = context.getPrice(100);


        System.out.println(price);


    }
}
