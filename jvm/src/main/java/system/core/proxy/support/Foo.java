package system.core.proxy.support;

/**
 * fuquanemail@gmail.com 2016/5/31 10:16
 * description:
 * 1.0.0
 */
public  class Foo {
    public static void staticMthod() {
        System.err.println("staticMthod");
    }

    public void method() {
        System.err.println("method");
    }

    public final void finalMethod(){
        System.err.println("finalMethod");
    }
}
