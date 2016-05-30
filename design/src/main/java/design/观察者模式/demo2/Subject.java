package design.观察者模式.demo2;

import design.观察者模式.demo2.observer.Observer;

/**
 * Hello-World 2015/8/9 11:34
 * fuquanemail@gmail.com
 */
public interface  Subject {


    /**
     * 注册观察者对象
     * @param observer    观察者对象
     */
    public void attach(Observer observer);
    /**
     * 删除观察者对象
     * @param observer    观察者对象
     */
    public void detach(Observer observer);
    /**
     * 通知所有注册的观察者对象
     */
    public void notifyObservers(String state);
}
