package design.装饰模式.demo1.decorator;

import design.装饰模式.demo1.Component;

/**
 * Hello-World 2015/8/8 12:57
 * fuquanemail@gmail.com
 */
public abstract class   AbstractDecorator implements Component{
    protected Component component;
    public abstract void setComponent(Component component);
}
