package design.策略模式.demo2.impl;

import design.策略模式.demo2.CalcStrategy;

/**
 * Hello-World 2015/8/5 22:43
 * fuquanemail@gmail.com
 *
 * 降价 20
 */
public class CalcStrategyB implements CalcStrategy {
    @Override
    public long calcPrice(long price) {
        return price - 20;
    }
}
