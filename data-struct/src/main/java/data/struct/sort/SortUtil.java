package data.struct.sort;

/**
 * fuquanemail@gmail.com 2016/6/13 16:47
 * description:
 * 1.0.0
 */
public class SortUtil {
    public static void swap(int[] arrray, int i, int j) {
        int tmp = arrray[i];
        arrray[i] = arrray[j];
        arrray[j] = tmp;
    }
}
