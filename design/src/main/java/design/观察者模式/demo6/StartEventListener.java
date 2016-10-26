package design.观察者模式.demo6;

/**
 * fuquanemail@gmail.com 2016/10/26 17:04
 * description:
 */
public class StartEventListener implements LifecycleListener {
    @Override
    public void lifecycleEvent(LifecycleEvent event) {
        if(event.getType().equals("start")){
            System.err.println("StartEventListener lifecycleEvent event :" + event.toString());
        }
    }
}