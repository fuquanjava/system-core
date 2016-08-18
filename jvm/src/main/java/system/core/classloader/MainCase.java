package system.core.classloader;

import system.core.classloader.classinit.InitClass;

/**
 * fuquanemail@gmail.com
 * -XX:+TraceClassLoading
 */
public class MainCase {
    public static void main(String[] args) {

        initClass();

    }

    private static void initClass() {
        // System.out.println(InitClass.a);
//        System.out.println(InitClass.b);
        InitClass.f();
        //System.out.println(new InitClass());

    }

}
