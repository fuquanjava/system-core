package system.core.guava.util;

import com.google.common.base.Preconditions;

/**
 * 前置条件校验
 */
public class PreconditionsTest {

    public static void main(String[] args) {

        f1();

    }

    public static void f1(){
        Preconditions.checkArgument(1== 2,"1== 2");
        Preconditions.checkNotNull(null,"null判断");


    }

}
