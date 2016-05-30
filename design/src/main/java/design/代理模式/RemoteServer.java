package design.代理模式;

/**
 * Hello-World 2015/8/8 13:51
 * fuquanemail@gmail.com
 */
public class RemoteServer implements Services {

    @Override
    public void services() {
        System.out.println("我是真正的服务者");
    }
}
