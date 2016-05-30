package design.单例模式.v2;

/**
 * fuquanemail@gmail.com 2016/5/26 14:42
 * description:饿汉式
 * 单例模式的饿汉式，在定义自身类型的成员变量时就将其实例化，
 * 使得在Singleton单例类被系统（姑且这么说）加载时就已经被实例化出一个单例对象，从而一劳永逸地避免了线程安全的问题。
 * 1.0.0
 */
public class Singleton {
    private static Singleton singleton = new Singleton();    //在定义变量时就将其实例化

    private Singleton(){
        System.out.println("构造函数被调用");
    }

    /**
     * 虽然饿汉式单例是线程安全的，但也有其不足之处。饿汉式单例在类被加载时就创建单例对象并且长驻内存，
     * 不管你需不需要它；如果单例类占用的资源比较多，就会降低资源利用率以及程序的运行效率。
     * 有一种更高级的单例模式则很好地解决了这个问题——静态内部类。
     * @return
     */
    public static Singleton getInstance1(){
        return singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton singleton = Singleton.getInstance1();

                }
            });

            thread.start();
        }
    }
}
