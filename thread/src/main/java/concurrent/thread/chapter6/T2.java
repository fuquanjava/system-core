package concurrent.thread.chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello-World 2015/8/25 21:12
 * fuquanemail@gmail.com
 */
public class T2 {

    private static  void handlerRequest(Socket socket) {
    }

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(80);
            while (true){
                final Socket socket = ss.accept();
                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        handlerRequest(socket);
                    }
                };
                new Thread(task).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
