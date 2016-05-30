package design.组合模式;

/**
 * Hello-World 2015/8/9 17:53
 * fuquanemail@gmail.com
 */
public abstract class Company {
    public String name;
    public abstract void add(Company company);
    public abstract void remove(Company company);
    public abstract void show();
}
