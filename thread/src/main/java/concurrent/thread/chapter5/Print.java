package concurrent.thread.chapter5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * hello.world 2015/6/14 17:52
 * fuquanemail@gmail.com
 *  打印工具类
 */
public class Print {
    public static void now(String message ){
        Date now = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = dateFormat.format(now);
        System.out.println(Thread.currentThread()+","+ message+"，当前时间:"+time);
    }
}
