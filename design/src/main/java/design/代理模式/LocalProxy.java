package design.代理模式;

/**
 * Hello-World 2015/8/8 13:49
 * fuquanemail@gmail.com
 */
public class LocalProxy implements Services{
    private RemoteServer remoteServer;

    @Override
    public void services() {
        System.out.println("我是代理....");
        remoteServer = new RemoteServer();
        remoteServer.services();
    }
}
