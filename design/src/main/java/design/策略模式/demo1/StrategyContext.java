package design.策略模式.demo1;

/**
 * Hello-World 2015/8/5 22:45
 * fuquanemail@gmail.com
 *
 * 策略上下文，维护一个策略的引用
 */
public class StrategyContext {

    private  CalcStrategy calcStrategy;

    public StrategyContext( CalcStrategy calcStrategy){
        this.calcStrategy = calcStrategy;
    }

    public long getPrice(long price){
        return calcStrategy.calcPrice(price);
    }

}
