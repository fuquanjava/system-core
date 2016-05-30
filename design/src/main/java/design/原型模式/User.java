package design.原型模式;

/**
 * Hello-World 2015/8/8 14:30
 * fuquanemail@gmail.com
 */
public class User implements Cloneable {

    public User(){
        System.out.println(" user 构造函数");
    }

    private Integer id;

    private String name;

    final private int age  = 1;

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }


    //    覆写了Object类中的clone方法！
    public User clone(){
        User user = null;
        try {
            user = (User) super.clone();
        }catch (Exception e){
            user = new User();
        }
        return user;
    }

    @Override
    public String toString() {
        return this.name+","+this.id+","+this.age;
    }
}
