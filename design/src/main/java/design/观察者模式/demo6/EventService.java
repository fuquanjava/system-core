package design.观察者模式.demo6;

/**
 * fuquanemail@gmail.com 2016/10/26 16:27
 * description:
 */
public class EventService extends AbstractLifecycle {


    @Override
    protected void stopInternal() {
        System.err.println("EventService stopInternal");
        fireLifecycleEvent("stop", "stop event Service");
    }

    @Override
    protected void startInternal() {
        System.err.println("EventService startInternal");
        fireLifecycleEvent("start", "start event Service");

    }
}
