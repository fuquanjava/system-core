package data.struct.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * fuquanemail@gmail.com 2016/6/13 16:45
 * description:
 * 1.0.0
 */
public class BubbleSort {
    static int a;
    private static Logger logger = LoggerFactory.getLogger(BubbleSort.class);

    public static void main(String[] args) {
        int[] array = {3, 1, 4, 2, 5};
        bubbleSort(array);
        System.err.println(Arrays.toString(array));

    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                a++;
                if (array[j] > array[j + 1]) {
                    SortUtil.swap(array, j, j + 1);
                }
                logger.info("第{}次排序的结果={}", a, Arrays.toString(array));
            }
        }
    }
}
