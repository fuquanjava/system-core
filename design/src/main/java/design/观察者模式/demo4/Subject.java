package design.观察者模式.demo4;

/**
 * fuquanemail@gmail.com 2016/3/10 11:39
 * description:
 * 1.0.0
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}
