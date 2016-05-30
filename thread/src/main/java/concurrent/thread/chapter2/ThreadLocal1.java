package concurrent.thread.chapter2;

/**
 * hello-world
 * 2015/9/16 19:08
 */
public class ThreadLocal1 {
    public static void main(String[] args) throws InterruptedException {
        final X x = new X();
        XM.setX(x);
        Thread t1 = new Thread(){
            public void run() {
                // XM.setX(x);
                X x = XM.getX();
                System.out.println(x.getA());
            }
        };
        Thread t2 = new Thread(){
            public void run() {
                // XM.setX(x);
                X x = XM.getX();
                System.out.println(x.hashCode());
                System.out.println(x.getA());
            }
        };
        t1.start();
        t2.start();
    }
}

class XM {
    static ThreadLocal<X> threadLocal = new ThreadLocal<>();
    public static void setX(X x){
        threadLocal.set(x);
    }
    public static X getX(){
        X x  = threadLocal.get();
        x.setA("a");
        return x;
    }
}

class X{
    private String a;
    public String getA() {
        return a;
    }
    public void setA(String a) {
        this.a = a;
    }
}

