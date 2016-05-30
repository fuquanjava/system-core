package concurrent.thread.chapter7;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Hello-World 2015/9/13 14:42
 * fuquanemail@gmail.com
 */
public class T5 extends Thread{
    private final Socket socket;
    private final InputStream inputStream;
    public T5(Socket socket, InputStream inputStream){
        this.socket = socket;
        this.inputStream = inputStream;
    }
    @Override
    public void interrupt() {
        try {
            socket.close();
        } catch (IOException e) {
        }
        super.interrupt();
    }
    @Override
    public void run() {
        while (true){
            try {
                int count = inputStream.read();
            } catch (IOException e) {
                //允许线程退出
            }
        }
    }
}
