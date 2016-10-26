package system.core.jvm.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * fuquanemail@gmail.com 2016/4/6 14:54
 * description: jvm 堆溢出
 * <p/>
 * java启动参数共分为三类；
 * 其一是标准参数（-），所有的JVM实现都必须实现这些参数的功能，而且向后兼容；
 * 其二是非标准参数（-X），默认jvm实现这些参数的功能，但是并不保证所有jvm实现都满足，且不保证向后兼容；
 * 其三是非Stable参数（-XX），此类参数各个jvm实现会有所不同，将来可能会随时取消，需要慎重使用；
 * <p/>
 * <p/>
 * <p/>
 * -verbose:gc                输出每次GC的相关情况。
 * -verbose:class             输出jvm载入类的相关信息，当jvm报告说找不到类或者类冲突时可此进行诊断。
 * -Xms20M                    初始化堆(最小值）
 * -Xmx20M                    最大堆
 * -Xmn10M                    Young Generation的大小 （eden+ from s1 + to s2)
 * -XX:+PrintGCDetails        打印gc详细
 * -XX:SurvivorRatio=8
 * <p/>
 * <p/>
 * 1.0.0
 *
 * -verbose:gc -Xms20M  -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
public class HeapOOM {
    private static final int _1MB = 1024 * 1024;
    static class OOMObject {
        // 1024*1024=1048576,也就是实例化 1048576 个byte . 转换后就是1M
        byte[] allocation = new byte[1024*256];  //直接分配在老年代中
    }

    public static void main(String[] args) throws InterruptedException {

        List<OOMObject> list = new ArrayList<OOMObject>();
        int i = 0;
        while (true) {

            System.err.println(i++);
            list.add(new OOMObject());
            Thread.sleep(100);


        }
    }
}
