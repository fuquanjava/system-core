package data.struct.sort;

import java.util.Arrays;

/**
 * fuquanemail@gmail.com 2016/6/14 11:33
 * description:
 * 1.0.0
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array1 = {3, 1, 2, 5, 4};
        shellSort(array1);
        System.err.println(Arrays.toString(array1));
    }

    public static void shellSort(int[] array) {

        int increment = array.length;
        do {
            increment = increment / 2;  // 增量序列
            for (int i = increment; i < array.length; i++) {

                if (array[i] < array[i - increment]) {
                    Integer guard = array[i];
                    int j;
                    //  记录后移，查找插入位置
                    for (j = i - increment; (j >= 0) && (guard < array[j]); j -= increment) {
                        array[j + increment] = array[j];
                    }
                    array[j + increment] = guard;  // 插入
                }
            }
        } while (increment > 1);
    }
}
