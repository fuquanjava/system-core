package concurrent.thread.chapter7;

/**
 * Hello-World 2015/9/13 15:57
 * fuquanemail@gmail.com
 */
public class T7 {
    public static void main(String[] args) {
        int i  = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.out.println("jvm关闭前的清理工作");
            }
        });
    }
}
