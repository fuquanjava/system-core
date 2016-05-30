package design.策略模式.demo2;


import design.策略模式.demo2.impl.CalcStrategyA;
import design.策略模式.demo2.impl.CalcStrategyB;

/**
 * Hello-World 2015/8/5 22:55
 * fuquanemail@gmail.com
 */
public class StrategyFactory {
    public static final String StrategyA = "StrategyA";
    public static final String StrategyB = "StrategyB";

    public static CalcStrategy init(String strategy) {

        CalcStrategy bean = null;
        switch (strategy) {
            case StrategyA:
                bean = new CalcStrategyA();
                break;
            case StrategyB:
                bean = new CalcStrategyB();
                break;
            default: bean = new CalcStrategyA();
        }
        return bean;
    }
}
