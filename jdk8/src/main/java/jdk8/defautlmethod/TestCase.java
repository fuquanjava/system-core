package jdk8.defautlmethod;

import java.util.Collections;

import org.junit.Test;

/**
 * @author libai
 */
public class TestCase {

    /**
     * 默认方法测试
     */
    @org.junit.Test
    public void test(){
        DefaultMethod.sayHi();
    }

    /**
     * 第一种方法引用是构造方法引用，语法是：Class::new ，对于泛型来说语法是：Class<T >::new，请注意构造方法没有参数:
     */
    @Test
    public void t2(){
        Car car = Car.create(Car::new);
        System.out.println(car);
    }

    /**
     * 第二种方法引用是静态方法引用，语法是：Class::static_method请注意这个静态方法只支持一个类型为Car的参数。
     */
    @Test
    public void t3(){
        Car car = Car.create(Car::new);
        Collections.singletonList(car).forEach(Car::collide);
    }

    /**
     * 第三种方法引用是类实例的方法引用，语法是：Class::method请注意方法没有参数。
     */
    @Test
    public void t4(){
        Car car = Car.create(Car::new);
        Collections.singletonList(car).forEach(Car::repair);
    }

    /**
     * 最后一种方法引用是引用特殊类的方法，语法是：instance::method，请注意只接受Car类型的一个参数。
     */
    @Test
    public void t5(){
        Car car = Car.create(Car::new);
        System.out.println(car);
    }

}
