package design.观察者模式.demo3;

/**
 * Hello-World 2015/8/9 11:56
 * fuquanemail@gmail.com
 */
public class MMSubject extends Subject {
    @Override
    public void updateState(String state) {
        System.out.println("state: "+ state);
        this.setState(state);
        this.nodifyObservers();
    }
}
