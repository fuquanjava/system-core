package design.观察者模式.demo6;

/**
 * fuquanemail@gmail.com 2016/10/26 16:17
 * description:
 *
 * Lifecycle 接口代表的是抽象主题，它定义了管理观察者的方法和它要所做的其它方法。而各组件代表的是具体主题，它实现了抽象主题的所有方法。
 *
 */
public interface Lifecycle {

    void start();

    void stop();

}
