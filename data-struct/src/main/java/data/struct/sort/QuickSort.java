package data.struct.sort;

import java.util.Arrays;

/**
 * fuquanemail@gmail.com
 * 2016/6/11
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {2, 3, 4, 5, 1};
        quickSort(array, 0, array.length - 1);
        System.err.println(Arrays.toString(array));
    }

    static void quickSort(int[] array, int lo, int hi) {

        if (lo >= hi) {
            return;
        }
        int mi = createPivot(array, lo, hi);
        quickSort(array, lo, mi-1);
        quickSort(array, mi + 1, hi);
    }

    private static int createPivot(int[] array, int lo, int hi) {
        int mi = array[lo];
        while (lo < hi) {
            while ((lo < hi) && array[hi] >= mi) {
                hi--;
            }
            if (lo < hi) {
                array[lo++] = array[hi];
            }

            while (lo < hi && array[lo] <= mi) {
                lo++;
            }
            if (lo < hi) {
                array[hi--] = array[lo];
            }
        }
        array[lo] = mi;
        return lo;

    }
}
