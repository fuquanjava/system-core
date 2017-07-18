package system.core.guava.collection;

import com.google.common.collect.ImmutableSet;

/**
 * 不可变集合
 *  当对象被不可信的库调用时，不可变形式是安全的；
    不可变对象被多个线程调用时，不存在竞态条件问题
    不可变集合不需要考虑变化，因此可以节省时间和空间。所有不可变的集合都比它们的可变形式有更好的内存利用率（分析和测试细节）；
    不可变对象因为有固定不变，可以作为常量来安全使用。
 */
public class ImmutableUtil {
    public static void main(String[] args) {
        f1();
    }

    public static void f1() {
        ImmutableSet<String> sets = ImmutableSet.of(
            "a",
            "b",
            "c",
            "c1",
            "d");

        System.out.println(sets);


        ImmutableSet<Object> set2 = ImmutableSet.builder().add(sets).build();
        System.out.println(set2);
    }
}
