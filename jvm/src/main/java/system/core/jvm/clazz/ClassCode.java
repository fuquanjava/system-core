package system.core.jvm.clazz;

/**
 * fuquanemail@gmail.com 2016/11/16 10:17
 * description:
 */
public class ClassCode {
    public static void main(String[] args) {
        int i = 1;
        int j = 2;

        int k = i + j;

        long b = 1L;
        long a = b + 2L;

        System.err.println(k);
        System.err.println(a);

        float f = 0f;

        System.err.println(f);

        returnAddress();
    }

    public static int returnAddress(){
        return 1;
    }
}
