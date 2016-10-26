package design.观察者模式.demo6;

/**
 * fuquanemail@gmail.com 2016/10/26 16:22
 * description:
 */
public abstract class AbstractLifecycle implements Lifecycle {

    private final LifecycleSupport lifecycle = new LifecycleSupport(this);


    public void addLifecycleListener(LifecycleListener listener) {
        lifecycle.addLifecycleListener(listener);
    }

    public LifecycleListener[] findLifecycleListeners() {
        return lifecycle.findLifecycleListeners();
    }


    public void removeLifecycleListener(LifecycleListener listener) {
        lifecycle.removeLifecycleListener(listener);
    }


    protected void fireLifecycleEvent(String type, Object data) {
        lifecycle.fireLifecycleEvent(type, data);
    }

    @Override
    public void stop() {
        System.err.println("AbstractLifecycle stop invoke start ...");
        stopInternal();
        System.err.println("AbstractLifecycle stop invoke end ...");
    }

    protected abstract void stopInternal();


    @Override
    public void start() {
        System.err.println("AbstractLifecycle start invoke start ...");
        startInternal();
        System.err.println("AbstractLifecycle start invoke end ...");

    }

    protected abstract void startInternal();
}
