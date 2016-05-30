package design.观察者模式.demo2;

import design.观察者模式.demo2.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello-World 2015/8/9 11:40
 * fuquanemail@gmail.com
 */
public class MMSubject implements Subject {
    /**
     * 用来保存注册的观察者对象
     */
    private List<Observer> list = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        list.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObservers(String state) {
        for(Observer observer : list){
            observer.update(state);
        }
    }
}
