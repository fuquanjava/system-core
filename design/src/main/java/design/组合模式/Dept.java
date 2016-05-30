package design.组合模式;

/**
 * Hello-World 2015/8/9 17:56
 * fuquanemail@gmail.com
 */
public class Dept extends Company {
    public Dept(String name){
        this.name= name;
    }
    @Override
    public void add(Company company) {
        //空实现
    }

    @Override
    public void remove(Company company) {
        //空实现
    }

    @Override
    public void show() {
        System.out.println("部门:"+name);
    }
}
