package system.core.jvm.directmemory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * fuquanemail@gmail.com 2016/4/6 15:34
 * description:
 * 1.0.0
 */
public class DirectMemoryOOM {
    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(1024*1024);
        }

    }
}
