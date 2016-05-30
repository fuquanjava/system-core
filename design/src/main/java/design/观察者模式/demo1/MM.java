package design.观察者模式.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello-World 2015/8/9 11:16
 * fuquanemail@gmail.com
 */
public class MM {
    private List<StockObserver> observerList = new ArrayList<>();

    private String action;

    public void attch(StockObserver observer){
        this.observerList.add(observer);
    }
    public void notifyObservers(){
        for(StockObserver observer : observerList){
            observer.update();
        }
    }
    public void remove(StockObserver observer){
        if(observerList.contains(observer)){
            observerList.remove(observer);
        }
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
