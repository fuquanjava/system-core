package design.原型模式;

/**
 * Hello-World 2015/8/8 14:31
 * fuquanemail@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        User u1 = new User();
        u1.setName("tom");
        u1.setId(1);

        // clone的时候不会执行构造函数
        User u2 = u1.clone();
        System.out.println(u1);
        System.out.println(u2);



    }
}
