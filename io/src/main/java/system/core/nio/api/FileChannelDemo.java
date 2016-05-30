package system.core.nio.api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * fuquanemail@gmail.com 2016/4/6 10:32
 * description:
 * 1.0.0
 */
public class FileChannelDemo {
    public static void main(String[] args) {
        readFile();

    }

    public static void readFile() {
        try {
            // RandomAccessFile 不存在 则创建
            RandomAccessFile accessFile = new RandomAccessFile("io\\src\\main\\resources\\nio-data.txt", "rw");
            FileChannel fileChannel = accessFile.getChannel();
            System.err.println("isOpen:" + fileChannel.isOpen());

            ByteBuffer buf = ByteBuffer.allocate(48);

            int bytesRead = fileChannel.read(buf);

            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                buf.flip();

                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }

                buf.clear();
                bytesRead = fileChannel.read(buf);
            }
            accessFile.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
