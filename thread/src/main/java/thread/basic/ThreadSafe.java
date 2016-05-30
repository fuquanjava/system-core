package thread.basic;

/**
 * hello.world 2014/5/13 15:53
 * fuquanemail@gmail.com
 * 线程控制逃逸规则
 *
 *  如果一个资源的创建，使用，销毁都在同一个线程内完成，
    且永远不会脱离该线程的控制，则该资源的使用就是线程安全的。

    即使对象本身线程安全，但如果该对象中包含其他资源（文件，数据库连接），整个应用也许就不再是线程安全的了
 *
 */
public class ThreadSafe {
    public static void main(String[] args) {

        // 注意两个Mythread共享了同一个Foo对象。因此，当它们调用f4()方法时会造成竞态条件。
        Foo foo = new Foo();
        new Thread(new Mythread(foo)).start();
        new Thread(new Mythread(foo)).start();

        // 如果不用的实例都不会存在问题
        new Thread(new Mythread(new Foo())).start();
        new Thread(new Mythread(new Foo())).start();




    }
}

class Mythread implements Runnable{
    Foo foo;
    public Mythread(Foo foo){
        this.foo = foo;
    }
    @Override
    public void run() {
            this.foo.f4("some thing");

    }
}

class Foo{

    /**
     * 非线程安全了：
     * 对象成员存储在堆上。如果两个线程同时更新同一个对象的同一个成员，那这个代码就不是线程安全的
     */
    StringBuilder builder = new StringBuilder();
    public void  f4(String text){
        this.builder.append(text);
    }


    public void f1(){
        // 局部变量存储在线程自己的栈中。
        // 也就是说，局部变量永远也不会被多个线程共享。所以，基础类型的局部变量是线程安全的
        int i = 0;
        i ++;
    }

    /**
     *样例中StringBuilder对象没有被方法返回，也没有被传递给f2()方法外的对象。
     *
     * 每个执行f2()的线程都会创建自己的StringBuilder对象，并赋值给sb引用。
     *
     * 因此，这里的StringBuilder是线程安全的。
     *
     * 事实上，整个f2()都是线程安全的。
     *
     * 即使将StringBuilder作为参数传给同一个类的其它方法或其它类的方法时，它仍然是线程安全的。
     *
     * 当然，如果sb通过某些方法被传给了别的线程，那它就不再是线程安全的了。
     */
    public void f2(){
        StringBuilder sb = new StringBuilder();
        sb.append("aa").append("bb");
    }
    public void f3(StringBuffer sb){
        System.out.println(sb.toString());
    }

}