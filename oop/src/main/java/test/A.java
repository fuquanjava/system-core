package test;

/**
 * fuquanemail@gmail.com 2016/10/27 14:37
 * description:
 */
public abstract class A {

    private B b = new B(this);

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public void printThis(){
        System.err.println(this.getClass());
    }
}
