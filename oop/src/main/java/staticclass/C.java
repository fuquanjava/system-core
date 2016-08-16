package staticclass;

/**
 * fuquanemail@gmail.com 2016/8/16 10:10
 * description:
 */
public class C {

    public static int a;

    public static void initA(){
        System.err.println("static init A");
        if(a== 1){
            a = 2;
        }
    }

    static {
        System.err.println("static block!");

        a = 1;

        initA();

    }


}
