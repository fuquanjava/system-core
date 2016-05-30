package design.装饰模式.demo1;

/**
 * Hello-World 2015/8/8 13:05
 * fuquanemail@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        //没有任何的修饰
        Component component = new ConcreteComponent();
        component.show();
        System.out.println("============================================");


    }
}
