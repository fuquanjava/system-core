package concurrent.thread.chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello-World 2015/8/25 7:13
 * fuquanemail@gmail.com
 * 串行的执行任务
 */
public class T1 {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(80);
            while (true){
                Socket socket = ss.accept();
                handleRequest(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void handleRequest(Socket socket) {
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
