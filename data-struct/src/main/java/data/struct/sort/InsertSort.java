package data.struct.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * fuquanemail@gmail.com
 * 2016/6/12
 *
 * 把数组分成2部分：左边已经排好，右边待排序. 从右边顺序取出元素， 在左边比较并确认最终的位置
 *
 *
 */
public class InsertSort {
    static int a;
    private static Logger logger = LoggerFactory.getLogger(InsertSort.class);

    public static void main(String[] args) {
        int[] array = {3, 1, 2, 5, 4};
        insertSort(array);
        System.err.println(Arrays.toString(array));
    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // j = i; 也就是在 array 的右边 取出一个元素
            for (int j = i; j > 0; j--) {

                // 如果取出的这个元素 小于 右边的(右边已经排好序)，则交换这个元素的位置
                if (array[j] < array[j - 1]) {
                    SortUtil.swap(array, j, j - 1);
                }
            }
            a++;
            logger.info("第{}次排序的结果={}", a, Arrays.toString(array));
        }
    }
}
