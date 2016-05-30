package design.门面模式;

/**
 * Hello-World 2015/8/8 15:35
 * fuquanemail@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        MapServicesFacade facade = new MapServicesFacadeImpl();
        facade.services();


    }
}
