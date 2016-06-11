package data.struct.sort;

/**
 * fuquanemail@gmail.com
 * 2016/6/11
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {2, 3, 1};
        //quickSort(array, 0, array.length - 1);

        swap(array,0, array.length -1);

        System.err.println(array);

    }

    static void quickSort(int[] array, int lo, int hi) {
        System.out.println("hi-lo = " + (hi - lo));
        if (lo >= hi) {
            return;
        }

        int mi = createPivot(array, lo, hi);
        quickSort(array, lo, mi);
        quickSort(array, mi + 1, hi);
    }

    private static int createPivot(int[] array, int lo, int hi) {
        int mi = array[0];
        while (lo < hi) {
            while ((lo < hi) && mi <= array[hi]) {
                hi--;
                swap(array, lo, hi);
            }
        }
        return lo;

    }

    private static void swap(int[] array, int lo, int hi) {
        int tmp = array[lo];
        array[lo] = array[hi];
        array[hi] = tmp;

    }
}
