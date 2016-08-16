package thread.locks;

/**
 * fuquanemail@gmail.com 2016/8/3 15:24
 * description:
 * 1.0.0
 */


public class SyncDemo {

    int i = 1;





    public synchronized void syncIncr() {
        i++;
    }

    public void incr() {
        i++;

    }

    public static void main(String[] args) {



    }


}
