package design.装饰模式.demo1.decorator;

import design.装饰模式.demo1.Component;

/**
 * Hello-World 2015/8/8 13:04
 * fuquanemail@gmail.com
 */
public class DecoratorAfter extends AbstractDecorator {

    @Override
    public void show() {
        if(component != null ){
            component.show();
        }
        this.after();
    }
    public void after(){
        System.out.println("我是方法后的修饰");
    }

    @Override
    public void setComponent(Component component) {
        this.component = component;
    }
}
