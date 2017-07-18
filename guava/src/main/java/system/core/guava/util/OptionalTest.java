package system.core.guava.util;

import com.google.common.base.Optional;

/**
 *  null: 原来的null 是不清楚的概念，比如 map.get(key) 返回 null, 不清楚是 value = null 还是 key不存在
 *
 *  Guava 用 Optional表示可能为 null 的 T 类型引用。一个 Optional 实例可能包含非 null 的引用（我们称之为引用存在），
 *  也可能什么也不包括（称之为引用缺失）。
 *
 *  它从不说包含的是 null 值，而是用存在或缺失来表示。但 Optional 从不会包含 null 值引用。
 *
 */
public class OptionalTest {

    public static void main(String[] args) {

        f3();

        f2();

        f1();


    }

    private static void f3() {
        Optional optional = Optional.fromNullable(null);
        System.out.println(optional);
        System.out.println(optional.isPresent());


    }

    public static void f1(){
        //创建指定引用的 Optional 实例，若引用为 null 则快速失败
        Optional<Integer> optional = Optional.of(5);
        System.out.println(optional.get());

        //isPresent() 如果 Optional 包含非 null 的引用（引用存在），返回true
        System.out.println(optional.isPresent());   //true

        // NullPointerException
        optional = Optional.of(null);
        System.out.println(optional);

    }

    public static void f2(){
        //创建引用缺失的 Optional 实例
        Optional optional = Optional.absent();
        System.out.println(optional);
        System.out.println(optional.isPresent()); // false
    }
}
