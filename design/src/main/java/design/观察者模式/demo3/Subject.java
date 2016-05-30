package design.观察者模式.demo3;

import design.观察者模式.demo3.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello-World 2015/8/9 11:50
 * fuquanemail@gmail.com
 */
public abstract class Subject {
    private List<Observer> list = new ArrayList<Observer>();
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void attach(Observer observer){
        list.add(observer);
    }
    public void detach(Observer observer){
        list.remove(observer);
    }
    public void nodifyObservers(){
        for(Observer observer : list){
            //传递的是 this
            observer.update(this);
        }
    }
    public abstract void updateState(String state);
}
