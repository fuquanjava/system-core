package guava.cache;

import com.google.common.base.Optional;

public class OptionalTest {
    public static void main(String[] args) {
       // f1();
        f2();
    }

    public static void f1(){
        Optional<Integer> optional = Optional.of(5);
        System.err.println(optional.isPresent()); // true
        System.err.println(optional.get()); // 5

        optional = Optional.of(null); // 会出现 NullPointerException，实现做了方法检查。

    }

    public static void f2(){
        Optional<Integer> optional = Optional.fromNullable(null);
        System.err.println(optional.get());
    }
}
