package data.struct.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;

/**
 * fuquanemail@gmail.com
 * 2016/6/11
 */
public class QuickSort {
    static final Logger LOG = LoggerFactory.getLogger(QuickSort.class);

    static int a;
    static int b;


    public static void main(String[] args) {
        int[] array = {2, 11, 4, 8, 1, 7, 3, 12, 9, 5, 6};
        //int[] array = {3, 1, 2, 4, 5};
        quickSort(array, 0, array.length - 1);
        System.err.println(Arrays.toString(array));
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void quickSort2(int[] array, int start, int end) {
        if (end <= start) {
            return;
        }
        int pivot = array[start];
        int storeIndex = start + 1;
        int i = start + 1;
        while (array[i] < pivot) {
            swap(array, i, storeIndex);
            System.err.println(Arrays.toString(array));
            storeIndex++;
            i++;

        }
        swap(array, array[start], storeIndex - 1);

    }


    /**
     * 快速排序
     *
     * @param array 待排序的数组
     * @param lo    起始元素位置
     * @param hi    终止元素位置
     */
    static void quickSort3(int[] array, int lo, int hi) {
        b++;
        if ((hi - lo) < 2) {
            return;
        }
        LOG.info("第[{}]次 quickSort,array={}", b, Arrays.toString(array));
        // 执行完1次之后，pivot位置的元素已经在最终的位置，这也是由于其他排序的特点
        int mi = createPivot3(array, lo, hi);
        //  只需要排序 lo - (mi-1)的元素
        quickSort3(array, lo, mi - 1);
        quickSort3(array, mi + 1, hi);
    }

    public static int createPivot3(int[] array, int lo, int hi) {
        // 随机元素跟首元素交换
        //Random random = new Random();
        //int r = random.nextInt(hi - lo);
        //SortUtil.swap(array,lo, r);

        a++;
        int pivot = array[lo];
        while (lo < hi) {
            while (lo < hi && array[hi] >= pivot) {
                hi--;
            }
            array[lo] = array[hi];
            LOG.info("第[{}]次 pivot={}, 从<<<<---查找之后,lo={}, hi={},array={}", a, pivot, lo, hi, Arrays.toString(array));

            while (lo < hi && array[lo] <= pivot) {
                lo++;
            }
            array[hi] = array[lo];
            LOG.info("第[{}]次 pivot={},从--->>>>查找之后,lo={}, hi={},array={}", a, pivot, lo, hi, Arrays.toString(array));
        } // lo == hi 的时候结束循环
        array[lo] = pivot;
        LOG.info("第[{}]次createPivot,pivot={},排序结果={}", a, pivot, Arrays.toString(array));
        return lo;

    }

    /**
     * 快速排序
     *
     * @param array
     * @param lo
     * @param hi
     */
    static void quickSort(int[] array, int lo, int hi) {
        b++;
        if (hi - lo < 2) {
            return;
        }
        LOG.info("第[{}]次 quickSort,array={}", b, Arrays.toString(array));
        // 执行完1次之后，pivot位置的元素已经在最终的位置，这也是由于其他排序的特点
        int mi = createPivot2(array, lo, hi);
        //  只需要排序 lo - (mi-1)的元素
        quickSort(array, lo, mi - 1);
        quickSort(array, mi + 1, hi);
    }

    /**
     * 演化版本
     *
     * @param array
     * @param lo
     * @param hi
     * @return
     */
    private static int createPivot2(int[] array, int lo, int hi) {
        a++;
        int pivot = array[lo]; //取第一个元素作为 pivot
        while (lo < hi) {
            while (lo < hi) {
                if (array[hi] > pivot) { // 在大于 pivot的前提下,向左扩展右端子向量
                    hi--;
                } else {
                    array[lo++] = array[hi]; // 直到遇到 不大于 pivot 的元素,将其归入左端子向量
                    break;
                }
            }
            LOG.info("第[{}]次从<<<<---查找之后,lo={}, hi={},array={}", a, lo, hi, Arrays.toString(array));

            while (lo < hi) {
                if (array[lo] < pivot) { // 在小于 pivot的前提下
                    lo++;  // 向右扩展左端子向量
                } else {
                    array[hi--] = array[lo]; // 直到遇到 不小于 pivot 的元素 ，将其归入右端子向量
                    break; //注意break;
                }
            }

            LOG.info("第[{}]次从--->>>>查找之后,lo={}, hi={},array={}", a, lo, hi, Arrays.toString(array));
        }

        // 结束条件是 lo = hi ,所以下面的代码等价。但lo = hi 也就是 pivot 分割的位置。
        //array[lo] = pivot;
        array[hi] = pivot;
        LOG.info("第[{}]次createPivot,pivot={},排序结果={}", a, pivot, Arrays.toString(array));
        return lo;

    }

    /**
     * 原始版本
     *
     * @param array
     * @param lo
     * @param hi
     * @return
     */
    private static int createPivot(int[] array, int lo, int hi) {
        a++;
        int pivot = array[lo]; //取第一个元素作为 pivot
        while (lo < hi) {
            // 从右向左 找到 第一个 小于 pivot(轴点)的元素
            while ((lo < hi) && array[hi] >= pivot) {
                hi--;
            }
            // 找到元素 把元素放在 左边 元素数组中，并且左边元素的指针往右移动1位，
            // 并且 array[hi] 这个位置是空的了。等下面的一个循环来填充
            if (lo < hi) {
                array[lo++] = array[hi];
            }
            LOG.info("第[{}]次从<<<<---查找之后,lo={}, hi={},array={}", a, lo, hi, Arrays.toString(array));

            // 从左向右 找到 第一个 大于 pivot(轴点)的元素
            while (lo < hi && array[lo] <= pivot) {
                lo++;
            }
            // 找到元素 把元素放在 右边 元素数组中(上面循环空的位置)，并且 hi 边元素的指针往左移动1位。回到上面的循环。
            // 并且 array[lo] 位置是空的
            if (lo < hi) {
                array[hi--] = array[lo];
            }
            LOG.info("第[{}]次从--->>>>查找之后,lo={}, hi={},array={}", a, lo, hi, Arrays.toString(array));
        }

        // 结束条件是 lo = hi ,所以下面的代码等价。但lo = hi 也就是 pivot 分割的位置。
        //array[lo] = pivot;
        array[hi] = pivot;
        LOG.info("第[{}]次createPivot,pivot={},排序结果={}", a, pivot, Arrays.toString(array));
        return lo;

    }
}
