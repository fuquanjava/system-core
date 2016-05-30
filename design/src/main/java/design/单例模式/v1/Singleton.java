package design.单例模式.v1;

/**
 * fuquanemail@gmail.com 2016/5/26 9:38
 * description:懒汉式
 * <p/>
 * 顾名思义，lazy loading（延迟加载，一说懒加载），在需要的时候才创建单例对象，而不是随着软件系统的运行或者当类被加载器加载的时候就创建。
 * 当单例类的创建或者单例对象的存在会消耗比较多的资源，常常采用lazy loading策略。
 * 这样做的一个明显好处是提高了软件系统的效率，节约内存资源
 * 1.0.0
 */
public class Singleton {
    private static Singleton instance = null;

    //构造方法被设为私有，防止外部使用new来创建对象，破坏单例
    private Singleton() {
        try {
            // 模拟线程延迟
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("构造函数被调用");
    }

    /**
     * 没有同步，会有并发危险
     */
    @Deprecated
    public static Singleton getInstance1() {
        if (instance == null) {    //第一次调用该方法时，创建对象。
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * 方法上同步锁，但是锁住一整个方法可能粒度过大，不利于效率。
     *
     * @return
     */
    public synchronized static Singleton getInstance2() {
        if (instance == null) {    //第一次调用该方法时，创建对象。
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * 现有线程A和B，在t1时刻线程A和B均已通过判空语句但都未取得锁资源；t2时刻时，A先取得锁资源进入临界区（被锁的代码块），
     * 执行new操作创建实例对象，然后退出临界区，释放锁资源。t3时刻，B取得被A释放的锁资源进入临界区，执行new操作创建实例对象，
     * 然后退出临界区，释放锁资源。明显地，Singleton被实例化两次.
     *
     * @return
     */
    @Deprecated
    public static Singleton getInstance3() {
        if (instance == null) {
            // t1 执行到这，然后交出 cpu .  t2 同样判断 instance == null 是 true。然后同样执行到这
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }

    /**
     * 虽然避免了上述的问题，但同  getInstance2 没有区别.会影响程序效率
     *
     * @return
     */
    public static Singleton getInstance4() {
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();

            }
        }
        return instance;
    }

    /**
     * 双重校验锁式（也有人把双重校验锁式和懒汉式归为一类）分别在代码锁前后进行判空校验，避免了多个有机会进入临界区的线程都创建对象.
     *
     * 经多次试验说明，双重校验锁式是线程安全的。然而，在JDK1.5以前，DCL是不稳定的，有时也可能创建多个实例，在1.5以后开始提供volatile关键字修饰变量来达到稳定效果。
     *
     *  网上都是这么说：我觉得不对。synchronized 已经保证 可见 和 顺序。
     *经多次试验说明，双重校验锁式是线程安全的。然而，在JDK1.5以前，DCL是不稳定的，有时也可能创建多个实例，在1.5以后开始提供volatile关键字修饰变量来达到稳定效果。
     * @return
     */
    public static Singleton getInstance5() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                    //return singleton;    //有人提议在此处进行一次返回
                }
                //return singleton;    //也有人提议在此处进行一次返回
            }
        }
        return instance;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 200; i++) {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton singleton = Singleton.getInstance5();

                }
            });

            thread.start();
        }
    }
}
