package design.观察者模式.demo3;

import design.观察者模式.demo3.observer.GameObserver;
import design.观察者模式.demo3.observer.Observer;

/**
 * Hello-World 2015/8/9 11:58
 * fuquanemail@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        Subject mm = new MMSubject();
        Observer game = new GameObserver();
        mm.attach(game);

        mm.updateState("老板来了....");

    }
}
