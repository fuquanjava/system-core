package concurrent.thread.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello-World 2015/8/16 12:43
 * fuquanemail@gmail.com
 */
public class T32 {
    public List<Handler> list = new ArrayList<>(); //发布List, 间接发布handler
    public static Handler handler; //其他代码可以访问
    public Handler getHandler(){  //非私有方法返回引用
        return handler;
    }
    public void execHandler(){ //传递到其他类的方法
        DoHandler.execHandler(handler);
    }
}

class Handler{ }

class DoHandler{
    public static void execHandler(Handler handler){

    }
}

class ThisEscape {
    int var ;
    public ThisEscape() {
        new Thread(new EscapeRunnable(


        )).start();


    }


}

class EscapeRunnable implements Runnable {
    @Override
    public void run() {
        // ThreadThisEscape.this就可以引用外围类对象, 但是此时外围类对象可能还没有构造完成, 即发生了外围类的this引用的逃逸

    }
}