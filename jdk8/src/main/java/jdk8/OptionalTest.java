package jdk8;

import java.util.Optional;

import org.junit.Test;

/**
 * Optional 只是一个容器，它可以保存一些类型的值或者null。它提供很多有用的方法，所以没有理由不显式地检查null
 */
public class OptionalTest {

    @Test
    public void t1() {
        Optional<String> name = Optional.ofNullable("a");

        //如果Optional实例有非空的值，方法 isPresent() 返回true否则返回false
        System.out.println(name.isPresent());

        //方法orElseGet提供了回退机制，当Optional的值为空时接受一个方法返回默认值.
        String e = name.orElseGet(() -> "None");
        System.out.println(e);

        //orElse方法和orElseGet类似，但是它不接受一个方法，而是接受一个默认值
        e = name.orElse("none");
        System.out.println(e);

        //map()方法转化Optional当前的值并且返回一个新的Optional实例

        Optional<String> other = name.map((s) -> s + "b");
        System.out.println(other.get());

        System.out.println(name.get());
    }

    @Test
    public void t2() {

        Runnable r1 = () -> {
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable r2 = () -> {
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        r1.run();

        r2.run();
    }
}
