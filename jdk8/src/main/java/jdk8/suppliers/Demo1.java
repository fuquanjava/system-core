package jdk8.suppliers;


import jdk8.suppliers.impl.DemoServiceImpl;

import java.util.function.Supplier;

public class Demo1 {

    public static <T> T get(Supplier<T> supplier){
        return supplier.get();
    }

    public static void main(String[] args) {

        Object r = get(()->{
            return 1;
        });

        System.err.println(r);


        DemoService service = new DemoServiceImpl();
        System.err.println(service.sayJSON("json"));
        System.err.println(service.sayHello("hello"));


    }



}
