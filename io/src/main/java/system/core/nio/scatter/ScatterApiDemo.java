package system.core.nio.scatter;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * fuquanemail@gmail.com 2016/6/2 11:46
 * description: 分散 : 一个 channel 读取到 多个 Buffer 里面
 * 1.0.0
 */
public class ScatterApiDemo {
    public static void main(String[] args) {


    }

    public static void scatterCharBuffer() {
        CharBuffer buffer = CharBuffer.allocate(3);
        buffer.put('a');
        buffer.put('b');
        buffer.put('c');
        buffer.flip();


        CharBuffer headBuffer = CharBuffer.allocate(1);
        CharBuffer bodyBuffer = CharBuffer.allocate(2);

        CharBuffer[] charBuffer = {headBuffer, bodyBuffer};

        

    }
}
