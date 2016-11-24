package test;

/**
 * fuquanemail@gmail.com 2016/10/27 14:40
 * description:
 */
public class C extends A {

    public static void main(String[] args) {
        D d  = new ID();

        D.R r = d.test(0);


        if(D.R.FAil.equals(r)){
            System.err.println("fail");
        }

        if(D.R.SUCCESS.equals(r)){
            System.err.println("SUCCESS");
        }
    }
}
