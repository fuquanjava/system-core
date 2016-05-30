package system.core.jvm.gc;

/**
 * fuquanemail@gmail.com 2016/4/8 14:54
 * description: 测试 minor gc
 * 1.0.0
 *
 -verbose:gc
 -Xms20M  初始堆
 -Xmx20M    最大堆
 -Xmn10M    新生代
 -XX:+PrintGCDetails
 -XX:SurvivorRatio=8    新生代Eden : Survivor = 8:1
 -XX:+UseSerialGC 指定使用 Serial 收集器
 -XX:PretenureSizeThreshold=3145728
 */
public class MinorGC {

    private static final int _1MB = 1024* 1024;

    public static void testMinorGC(){
        byte [] b1, b2, b3,b4, b5;
        b1 = new byte[2* _1MB];
       b2 = new byte[2* _1MB];
       b3 = new byte[2* _1MB];
        b4 = new byte[4* _1MB];
    }

    public static void main(String[] args) {
        testMinorGC();
    }
}
