package system.core.jvm.stack;

/**
 * fuquanemail@gmail.com 2016/4/6 15:15
 * description:
 *
 * -Xss128k：

 设置每个线程的堆栈大小。

 JDK5.0以后每个线程堆栈大小为1M，以前每个线程堆栈大小为256K。
 更具应用的线程所需内存大小进行调整。

 在相同物理内 存下，减小这个值能生成更多的线程。但是操作系统对一个进程内的线程数还是有限制的，不能无限生成，经验值在3000~5000左右。

 * 1.0.0
 */
public class JavaVMStackSOF {
    private static int stackLength = 1;
    public static void stackLeak(){
        stackLength++;
        System.err.println(stackLength);
        stackLeak();
    }

    public static void main(String[] args) {
        stackLeak();
    }
}
