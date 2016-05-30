package design.观察者模式.demo2.observer;

/**
 * Hello-World 2015/8/9 11:39
 * fuquanemail@gmail.com
 */
public class NBAObserver implements Observer {
    @Override
    public void update(String state) {
        System.out.println("NBAObserver:"+state);
    }
}
