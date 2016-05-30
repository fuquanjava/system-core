package design.装饰模式.demo1;

/**
 * Hello-World 2015/8/8 12:54
 * fuquanemail@gmail.com
 */
public class ConcreteComponent implements Component {
    @Override
    public void show() {
        System.out.println("我是具体对象的show ..");
    }
}
