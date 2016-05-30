package design.观察者模式.demo1;

/**
 * Hello-World 2015/8/9 11:23
 * fuquanemail@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        MM mm = new MM();

        StockObserver o1 = new StockObserver("tom", mm);
        StockObserver o2 = new StockObserver("jerry", mm);


        mm.attch(o1);
        mm.attch(o2);

        mm.setAction("老板来了..");
        mm.notifyObservers();

        mm.setAction("老板走了..");
        mm.notifyObservers();

    }
}
