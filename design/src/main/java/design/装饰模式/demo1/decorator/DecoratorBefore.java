package design.装饰模式.demo1.decorator;

import design.装饰模式.demo1.Component;

/**
 * Hello-World 2015/8/8 13:02
 * fuquanemail@gmail.com
 */
public class DecoratorBefore extends AbstractDecorator {

    public void decoratorMethod() {
        System.out.println("我是方法前的装饰");
    }

    @Override
    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public void show() {
        this.decoratorMethod();
        if(null != component){
            this.show();
        }
    }
}
