package jdk8.lambda;

public class Demo3 {

    public static void run(String name){
        String s = "hello";
//        尽管我们放宽了对捕获变量的语法限制，但试图修改捕获变量的行为仍然会被禁止，比如下面这个例子就是非法的 , 变量 s 是不能修改的。

        //s = "hello Java";
        final String s2 = "Hello S2";

        Runnable r1 = ()->{
            System.err.println(s);
            System.err.println(s2);
        };


        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.err.println(s);
                System.err.println(s2);
            }
        };

        r1.run();
        r2.run();

    }


    public static void main(String[] args) {
            run("Lambda");



    }
}
