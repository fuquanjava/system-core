package design.建造者模式;

/**
 * Hello-World 2015/8/8 16:01
 * fuquanemail@gmail.com
 * 指挥类
 */
public class Director {
    public void contruct(Ask4leaveBuilder builder){
        builder.ask1();
        builder.ask2();
        builder.ask3();

    }
}
