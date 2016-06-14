package data.struct.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * fuquanemail@gmail.com 2016/6/14 9:56
 * description:
 * 1.0.0
 * <p/>
 * 1) 选择排序原理:
 * a 将数组中的每个元素,与第一个元素比较 .如果这个元素小于第一个元素, 就将两个元素交换.
 * b 每轮使用a的规则, 可以选择出一个最小元素放到第一个位置.
 * c 经过n-1轮比较完成排序
 * <p/>
 * 简单说: 每轮选择最小的放到前面.
 */
public class SelectSort {
    static int a;
    private static Logger logger = LoggerFactory.getLogger(SelectSort.class);

    public static void main(String[] args) {
        int[] array = {3, 1, 4, 2, 5};
        selectSort2(array);
        System.err.println(Arrays.toString(array));

    }

    private static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[i]) {
                    SortUtil.swap(array, j, i);
                }

            }
        }
    }

    private static void selectSort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    SortUtil.swap(array, j, i);
                }

            }
        }
    }
}
