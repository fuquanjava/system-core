package design.观察者模式.demo6;

/**
 * fuquanemail@gmail.com 2016/10/26 17:03
 * description:
 */
public class Test {
    public static void main(String[] args) {

        EventService service = new EventService();
        service.addLifecycleListener(new StopEventListener());
        service.addLifecycleListener(new StartEventListener());

        //service.startInternal();
        service.stopInternal();
    }
}
