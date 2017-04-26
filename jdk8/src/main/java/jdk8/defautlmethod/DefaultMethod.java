package jdk8.defautlmethod;

/**
 * defaut method
 *
 * 记住默认的方法和静态方法（下一节会具体解释）不会违反函数接口的约定
 *JVM平台的接口的默认方法实现是很高效的，并且方法调用的字节码指令支持默认方法。默认方法使已经存在的接口可以修改而不会影响编译的过程
 *
 */

@FunctionalInterface
public interface DefaultMethod {

    // 修饰符 public
    default void sayHello() {
        System.err.println("hello");
    }

    /**
     * 静态方法：接口里可以声明静态方法，并且可以实现
     */
    static void sayHi() {
        System.out.printf("Hi");
    }

    void method();
}
