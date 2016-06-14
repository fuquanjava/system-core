package data.struct.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * fuquanemail@gmail.com 2016/6/13 16:45
 * description:
 * 1.0.0
 * <p/>
 * 冒泡排序原理:
 * a 逐一比较数组中相邻的两个元素, 如果后面的数字小于前面的数字, 就交换先后元素.
 * b 经过一个轮次的比较, 一定有一个最大的排在最后的位置.
 * c 每次比较剩下的元素, 经过n-1次比较, 可以 实现排序
 * 简单说: 比较相邻元素,大的向后交换
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
