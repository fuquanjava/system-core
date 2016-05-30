package design.单例模式.v3;

import java.io.*;

/**
 * fuquanemail@gmail.com 2016/5/26 14:58
 * description:
 * 1.0.0
 */
public class Singleton implements Serializable {
    private Singleton(){
        System.out.println("构造函数被调用");
    }

    /**
     * 静态内部类式和饿汉式一样，同样利用了ClassLoader的机制保证了线程安全；
     * 不同的是，饿汉式在Singleton类被加载时（从代码段3-2的Class.forName可见）就创建了一个实例对象，
     * 而静态内部类即使Singleton类被加载也不会创建单例对象，除非调用里面的getInstance()方法。
     * 因为当Singleton类被加载时，其静态内部类SingletonHolder没有被主动使用。
     *  只有当调用getInstance方法时，才会装载SingletonHolder类，从而实例化单例对象。
        这样，通过静态内部类的方法就实现了lazy loading，很好地将懒汉式和饿汉式结合起来，既实现延迟加载，保证系统性能，也能保证线程安全
     * @return
     */
    public static Singleton getInstance(){
        return SingletonHolder.instance;
    }


    private static class SingletonHolder{
        private static Singleton instance = new Singleton();
    }

    /**
     * 通过在Singleton类添加readResolve()方法来解决：
     * @return Object
     */
    private Object readResolve() {
        System.out.println("readResolve()被调用");
        return getInstance();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(arrayOutputStream);
        Singleton singleton = getInstance();

        outputStream.writeObject(singleton);
        /**
         * 对于上述四种方式的单例模式，如果你的Singleton类实现了Serializable序列化接口，
         * 那么可能会被序列化生成多个实例，因为readObject()方法一直返回一个新的对象.
         */

        ObjectInputStream ois1 = new ObjectInputStream(new ByteArrayInputStream(arrayOutputStream.toByteArray()));
        singleton=  (Singleton) ois1.readObject();
        System.err.println(singleton);

        ObjectInputStream ois2 = new ObjectInputStream(new ByteArrayInputStream(arrayOutputStream.toByteArray()));
        singleton=  (Singleton) ois2.readObject();
        System.err.println(singleton);



        for (int i = 0; i < 20; i++) {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton singleton = Singleton.getInstance();

                }
            });

            thread.start();
        }
    }

}
