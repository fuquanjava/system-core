package staticclass;

/**
 * fuquanemail@gmail.com 2016/4/12 16:17
 * description:
 * 1.0.0
 */
public class ServiceB {

    /* private static ServiceA serviceA = new ServiceA();

     public static void callADoing(String name, String doing){
         serviceA.doing(name, doing);
     }
 */
    public static void main(String[] args) {
        C c1 = new C();
        C c2 = new C();
        System.err.println(c1.a);
        System.err.println(c2.a);
    }
}
