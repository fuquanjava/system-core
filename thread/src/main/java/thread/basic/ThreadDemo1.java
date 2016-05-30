package thread.basic;

/**
 * hello.world 2014/5/13 15:53
 * fuquanemail@gmail.com
 *
 * 创建子类还是实现Runnable接口？

 对于这两种方式哪种好并没有一个确定的答案，它们都能满足要求。

 就我个人意见，我更倾向于实现Runnable接口这种方法。

 因为线程池可以有效的管理实现了Runnable接口的线程，

 如果线程池满了，新的线程就会排队等候执行，直到线程池空闲出来为止。

 而如果线程是通过实现Thread子类实现的，这将会复杂一些。

 有时我们要同时融合实现Runnable接口和Thread子类两种方式。

 例如，实现了Thread子类的实例可以执行多个实现了Runnable接口的线程。一个典型的应用就是线程池


 */
public class ThreadDemo1 {

    public static void main(String[] args) {
        // 继承
        Mythead1 t1 = new Mythead1();
        t1.start();

        //实现runnable接口
        Thread t2 = new Thread(new Mythread2());
        t2.start();

        //匿名内部类
        Thread t3 = new Thread(){
            @Override
            public void run() {
                System.out.println(" 匿名 t3 run ...");
            }
        };
        t3.start();

    }
}

class Mythead1 extends Thread{
    @Override
    public void run() {
        System.out.println("Mythead1 run ... ");
    }
}

class  Mythread2 implements Runnable{

    @Override
    public void run() {
        System.out.println("Mythread2 run ...");
    }
}