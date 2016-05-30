package design.观察者模式.demo3.observer;


import design.观察者模式.demo3.Subject;

/**
 * Hello-World 2015/8/9 11:54
 * fuquanemail@gmail.com
 */
public class GameObserver implements Observer {
    @Override
    public void update(Subject subject) {
        System.out.println(subject.getClass().getSimpleName());
        System.out.println(subject.getState());
    }
}
