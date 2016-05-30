package concurrent.thread.chapter5;

import java.util.Vector;

/**
 * Hello-World 2015/8/20 22:04
 * fuquanemail@gmail.com
 */
public class T1 {
    public static Object getLast(Vector vector){
        int lastIndex = vector.size() - 1;
        return vector.get(lastIndex);
    }

    public  static void deleteLast(Vector vector){
        synchronized (vector) {
            int lastIndex = vector.size() - 1;
            vector.remove(lastIndex);
        }
    }
}
