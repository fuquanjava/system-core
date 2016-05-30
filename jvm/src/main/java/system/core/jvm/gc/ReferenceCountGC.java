package system.core.jvm.gc;

/**
 * fuquanemail@gmail.com 2016/4/7 9:11
 * description: 对象之间的循环依赖
 * 1.0.0
 */
public class ReferenceCountGC {

    public Object instance = null;

    private static final int _1MB = 1024* 1024;

    private byte [] bigSize = new byte[1*_1MB];

    @Override
    protected void finalize() throws Throwable {
        System.err.println("finalize"+ this);
    }

    public static void main(String[] args) {
        System.err.println("中文");
        ReferenceCountGC a = new ReferenceCountGC();
        ReferenceCountGC b = new ReferenceCountGC();

        a.instance = b;
        b.instance = a;

        a = null;
        b = null;

        System.gc();


    }
}
