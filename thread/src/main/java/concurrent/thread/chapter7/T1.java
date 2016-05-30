package concurrent.thread.chapter7;

/**
 * Hello-World 2015/9/5 11:11
 * fuquanemail@gmail.com
 */
public class T1 {
    public static void main(String[] args) {
        T11 t11 = new T11();
        t11.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            t11.setCancel();
        }

    }

}

class T11 extends Thread{
    private volatile boolean isCancel = Boolean.FALSE;
    @Override
    public void run() {
        int i = 0;
        while (! isCancel){
            System.out.println(i++);
        }
    }
    public void setCancel(){
        isCancel = Boolean.TRUE;
    }
}
