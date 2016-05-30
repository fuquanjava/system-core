package concurrent.thread.chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;

/**
 * Hello-World 2015/8/25 7:13
 * fuquanemail@gmail.com
 * 串行的执行任务
 */
public class T3 {
    private static Executor singleThread = new TT3();
    private static Executor multiThread  = new TT33();
    static class TT33 implements Executor{
        @Override
        public void execute(Runnable command) {
            new Thread(command).start();
        }
    }
    static class TT3 implements Executor{
        @Override
        public void execute(Runnable command) {
            command.run();
        }
    }
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(80);
            while (true){
                final Socket socket = ss.accept();
                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        handleRequest(socket);
                    }
                };
                singleThread.execute(task);
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
