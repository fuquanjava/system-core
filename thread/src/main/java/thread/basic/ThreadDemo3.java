package thread.basic;

/**
 * hello.world 2015/6/13 16:22
 * fuquanemail@gmail.com
 * 当多个线程同时访问同一个资源，并且其中的一个或者多个线程对这个资源进行了写操作，才会产生竞态条件。
 * 多个线程同时读同一个资源不会产生竞态条件。
 *
 */
public class ThreadDemo3 {
    public static void main(String[] args) {


    }
}

// 通过创建不可变的共享对象来保证对象在线程间共享时不会被修改，从而实现线程安全
// value 通过构造器赋值，并且在类中没有set方法。
//
// 这意味着一旦ImmutableValue实例被创建，value变量就不能再被修改，这就是不可变性。
//
// 但你可以通过getValue()方法读取这个变量的值
class ImmutableValue{
    private int value = 0;

    public ImmutableValue(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    //注意add()方法以加法操作的结果作为一个新的ImmutableValue类实例返回，而不是直接对它自己的value变量进行操作
    public ImmutableValue add(int valueToAdd){
        return new ImmutableValue(this.value + valueToAdd);
    }
}
//即使一个对象是线程安全的不可变对象，指向这个对象的引用也可能不是线程安全的
// Calculator类持有一个指向ImmutableValue实例的引用。
//
// 注意，通过setValue()方法和add()方法可能会改变这个引用。
//
// 因此，即使Calculator类内部使用了一个不可变对象，但Calculator类本身还是可变的，因此Calculator类不是线程安全的。
//
// 换句话说：ImmutableValue类是线程安全的，但使用它的类不是。当尝试通过不可变性去获得线程安全时，这点是需要牢记的。

class Calculator {
    private ImmutableValue currentValue = null;

    public ImmutableValue getValue() {
        return currentValue;
    }

    public void setValue(ImmutableValue newValue) {
        this.currentValue = newValue;
    }

    public void add(int newValue) {
        this.currentValue = this.currentValue.add(newValue);
    }
}
