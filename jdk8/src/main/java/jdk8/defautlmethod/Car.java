package jdk8.defautlmethod;

import java.util.function.Supplier;
/**
 * lambda 方法引用
 *
 *   静态方法引用：ClassName::methodName
 *   实例上的实例方法引用：instanceReference::methodName
 *   超类上的实例方法引用：super::methodName
 *   类型上的实例方法引用：ClassName::methodName
 *   构造方法引用：Class::new
 *   数组构造方法引用：TypeName[]::new
 *
 *
 */
public class Car {

    public Car() {
        System.out.println("car constructor");
    }

    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    @Override
    public String toString() {
        return "Car";
    }
}
