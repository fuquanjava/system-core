package system.core.classloader.classinit;

/**
 * fuquanemail@gmail.com
 */
public class InitClass {

    public static final int a = 1; //编译期间的确定的常量池，不会触发类初始化

    public static int b = 2;

    static {
        System.out.println("静态代码块.");
    }

    public static void f(){
        System.out.println("print f");
    }

    public InitClass(){
        System.out.println("构造器初始化");
    }

}
