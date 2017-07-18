package generics;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 泛型
 */
public class ApiTest {

    /**
     * 显然在平时使用中，ArrayList<Integer>()和new ArrayList<String>()是完全不同的类型，但是在这里，程序却的的确确会输出true。
     *
     * 这就是Java泛型的类型擦除造成的，因为不管是ArrayList<Integer>()还是new ArrayList<String>()，都在编译器被编译器擦除成了ArrayList。
     * 那编译器为什么要做这件事？原因也和大多数的Java让人不爽的点一样——兼容性。
     *
     * 由于泛型并不是从Java诞生就存在的一个特性，而是等到SE5才被加入的，所以为了兼容之前并未使用泛型的类库和代码，不得不让编译器擦除掉代码中有关于泛型类型信息的部分，
     * 这样最后生成出来的代码其实是『泛型无关』的，我们使用别人的代码或者类库时也就不需要关心对方代码是否已经『泛化』，反之亦然。
     *
     * 下面代码编译后 的字节码一样
     */
    @Test
    public void t1() {
        Class c1 = new ArrayList<Integer>().getClass();
        Class c2 = new ArrayList<String>().getClass();

        System.out.println(c1 == c2);
    }
}
