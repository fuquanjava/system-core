package design.观察者模式.demo2.observer;

/**
 * Hello-World 2015/8/9 11:37
 * fuquanemail@gmail.com
 */
public class StockObserver implements Observer {

    @Override
    public void update(String state) {
        System.out.println("StockObserver："+ state);
    }
}
