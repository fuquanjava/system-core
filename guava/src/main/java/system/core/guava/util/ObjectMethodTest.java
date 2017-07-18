package system.core.guava.util;

import java.util.Objects;

/**
 *
 */
public class ObjectMethodTest {

    public static void main(String[] args) {

        f1();

    }

    public static void f1() {
        boolean equal = Objects.equals(null, "b");

        System.out.println(equal);

        System.out.println(com.google.common.base.MoreObjects.toStringHelper(ObjectMethodTest.class));
    }

    @Override
    public String toString() {
        return "ObjectMethodTest";
    }
}
