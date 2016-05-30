package design.策略模式.demo2;


/**
 * Hello-World 2015/8/5 22:47
 * fuquanemail@gmail.com
 */
public class Main {
    public static void main(String[] args) {

        //客户端 并不知道 策略B 是如何实现的.
        StrategyContext context = new StrategyContext(StrategyFactory.StrategyB);

        long price = context.getPrice(100);


        System.out.println(price);


    }
}
