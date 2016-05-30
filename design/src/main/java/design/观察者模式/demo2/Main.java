package design.观察者模式.demo2;

import design.观察者模式.demo2.observer.NBAObserver;
import design.观察者模式.demo2.observer.Observer;
import design.观察者模式.demo2.observer.StockObserver;

/**
 * Hello-World 2015/8/9 11:43
 * fuquanemail@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        Subject mm = new MMSubject();
        Observer stock = new StockObserver();
        Observer nba = new NBAObserver();

        mm.attach(stock);
        mm.attach(nba);

        mm.notifyObservers("老板来了");




    }
}
