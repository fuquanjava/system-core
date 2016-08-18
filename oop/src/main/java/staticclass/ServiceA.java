package staticclass;

/**
 * fuquanemail@gmail.com 2016/4/12 16:15
 * description:
 * 1.0.0
 */
public class ServiceA {

    static {
        System.err.println("static");
    }

    {
        System.err.println("code block");
    }

    public static final int a = 1;

    public void doing(String name , String doing){
        System.err.println(name + "do-" + doing);
    }
}
