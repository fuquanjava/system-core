package concurrent.thread.chapter2;

/**
 * hello-world
 * 2015/9/15 15:33
 */
public class T1 {
    final A a;
    public T1(A a) {
        this.a = a;
    }
    public class T22 implements Runnable {
        @Override
        public void run() {
            synchronized (T22.class) {
                a.i++;
            }
        }
    }

    public  class T32 implements Runnable {
        @Override
        public void run() {

        }
    }


}

class A {
    public long i;

}
