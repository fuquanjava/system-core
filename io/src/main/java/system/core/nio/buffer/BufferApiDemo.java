package system.core.nio.buffer;

import java.nio.CharBuffer;

/**
 * fuquanemail@gmail.com 2016/6/2 11:05
 * description:
 * 1.0.0
 */
public class BufferApiDemo {
    public static void main(String[] args) {
        //wirteBuffer();
        //readBuffer();
        clearBuffer();
    }

    private static void clearBuffer() {
        CharBuffer buff = CharBuffer.allocate(8);
        System.out.println("capacity:" + buff.capacity());
        System.out.println("limit:" + buff.limit());
        System.out.println("position:" + buff.position());
        buff.put('a');
        buff.put('b');
        buff.put('c');
        System.out.println("加入三个元素后,position=" + buff.position());
        buff.flip();
        System.out.println("执行flip后,limit=" + buff.limit());
        System.out.println("position=" + buff.position());
       //取出第一个元素
        System.out.println("第一个元素(position=0):" + buff.get());
        System.out.println("取出第一个元素后,position=" + buff.position());
        buff.clear();
        System.out.println("执行clear方法后,limit=" + buff.limit());
        System.out.println("执行clear方法后,position=" + buff.position());
        System.out.println("执行clear后,缓冲区的内容并没有被清空.第三个元素为:" + buff.get(2));
        System.out.println("执行绝对读取后,position=" + buff.position());

        buff.compact();


    }

    private static void readBuffer() {
        CharBuffer charBuffer = CharBuffer.allocate(2);
        charBuffer.put('a');
        charBuffer.put('b');

        charBuffer.flip(); // 模式切换

        char c = charBuffer.get();
        System.err.println(c);

        c = charBuffer.get(0); // 从指定position读取，或者从Buffer中读取数据到字节数组
        System.err.println(c);

        //将position设回0，所以你可以重读Buffer中的所有数据。limit保持不变，仍然表示能从Buffer中读取多少个元素
        charBuffer.rewind();

        c = charBuffer.get();
        System.err.println(c);

        c = charBuffer.get();
        System.err.println(c);


        charBuffer.clear();

    }

    public static void wirteBuffer() {

        CharBuffer charBuffer = CharBuffer.allocate(2);
        charBuffer.put('a');
        charBuffer.put('b');
        // 2个字符的buffer，写入三个字符，java.nio.BufferOverflowException
        //charBuffer.put('c');

        System.err.println(charBuffer.position());
        System.err.println(charBuffer.limit());
        System.err.println(charBuffer.capacity());
    }
}
