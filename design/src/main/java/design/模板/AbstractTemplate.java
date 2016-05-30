package design.模板;

/**
 * Hello-World 2015/8/8 15:24
 * fuquanemail@gmail.com
 */
public abstract class AbstractTemplate {
    protected abstract void conn();
    protected abstract void release();

    public void save(){
        this.conn();
        System.out.println("save ....");
        this.release();
    }
}
