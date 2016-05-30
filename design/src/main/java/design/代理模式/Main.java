package design.代理模式;

/**
 * Hello-World 2015/8/8 13:54
 * fuquanemail@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        Services services = new LocalProxy();
        services.services();

    }
}
