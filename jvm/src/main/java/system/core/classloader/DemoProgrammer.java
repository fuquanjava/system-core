package system.core.classloader;

/**
 * fuquanemail@gmail.com 2016/4/18 10:10
 * description:
 * 1.0.0
 *
 * java code
 */
public class DemoProgrammer {
    public void code() {
        System.out.println("I'm a Programmer,Just Coding.....");
    }

    public static void main(String[] args) {
        // build class code
        DemoProgrammer demoProgrammer = new DemoProgrammer();
        demoProgrammer.code();
    }
}
