package concurrent.thread.chapter2;

/**
 * hello-world
 * 2015/9/17 14:31
 */
public class MapTest {
    public static void main(String[] args) {
        A1 a = new A1();
        System.out.println(Integer.toBinaryString(a.hashCode()));
        int hash = hash(a);
        System.out.println(Integer.toBinaryString(hash));
        f(15);



    }

    public static int hash(A1 k) {
        int h = 0;
        h ^= k.hashCode();
        System.out.println(Integer.toBinaryString(h));
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        System.out.println(Integer.toBinaryString(h));
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
    public static void f(int initialCapacity){
        int capacity = 1;
        while (capacity < initialCapacity)
            capacity <<= 1;

        System.out.println(capacity);
    }

}

class A1{
    @Override
    public int hashCode() {
        return 32768;
    }
}
