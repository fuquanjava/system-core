package jdk8.lambda;


import java.security.PrivilegedAction;
import java.util.Arrays;

import java.util.List;

import static java.security.AccessController.doPrivileged;

public class Demo1 {


    interface funInterface {
        String sayHello();
    }

    public static void main(String[] args) {

        test1();


    }

    public static void test1() {
        Arrays.asList("a", "b", "c").forEach(e -> {
            System.err.println(e);
        });

//        请注意到编译器会根据上下文来推测参数的类型，或者你也可以显示地指定参数类型，只需要将类型包在括号里。举个例子：
        getList().forEach((String e) ->  //注意 这里没有大括号
                System.err.println(e)
        );


//        如果Lambda的功能语句块太复杂，我们可以用大括号包起来，跟普通的Java方法一样，如下：
        getList().forEach((String e) -> {
            System.err.println("我是有大括号的：：" + e);
        });


//        Lambda表达式可能会引用类的成员或者局部变量（会被隐式地转变成final类型），下面两种写法的效果是一样的：
        String s1 = "abc";
        getList().forEach(e -> System.err.println(s1 + ":::" + e));


//        Lambda表达式可能会有返回值，编译器会根据上下文推断返回值的类型。如果lambda的语句块只有一行，不需要return关键字。下面两个写法是等价的：
        getList().sort((e1, e2) -> e1.compareTo(e2));

        getList().sort((e1, e2) -> {
            int sort = e1.compareTo(e2);
            return sort;
        });


        //
        test2(() -> {
            System.err.println("Haha");
        });

        String s = test2(() -> {
            return "aa";
        });

        System.err.println(s);

        String user = doPrivileged((PrivilegedAction<String>) () -> System.getProperty("user.name"));
        System.err.println(user);

    }

    public static void test2(Runnable r) {
        System.err.println("test2 Runnable");
        r.run();
    }

    public static String test2(funInterface r) {
        System.err.println("test2 funInterface");
        return r.sayHello();
    }


    public static List<String> getList() {
        return Arrays.asList("a", "b", "c");
    }
}
