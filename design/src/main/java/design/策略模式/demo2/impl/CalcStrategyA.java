package design.策略模式.demo2.impl;

import design.策略模式.demo2.CalcStrategy;

/**
 * Hello-World 2015/8/5 22:42
 * fuquanemail@gmail.com
 * 策略A ： 打5折
 */
public class CalcStrategyA implements CalcStrategy {
    @Override
    public long calcPrice(long price) {
        return price / 2;
    }
}
