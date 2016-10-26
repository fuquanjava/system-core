package design.观察者模式.demo6;

/**
 * fuquanemail@gmail.com 2016/10/26 16:18
 * description:
 *
 * LifecycleListener代表的是抽象观察者，它定义一个lifecycleEvent方法，而实现该接口的监听器是作为具体的观察者。
 *
 */
public interface LifecycleListener {

    void lifecycleEvent(LifecycleEvent event);

}
