package data.struct.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * fuquanemail@gmail.com
 * 2016/6/12
 * <p/>
 * 把数组分成2部分：左边已经排好，右边待排序. 从右边顺序取出元素， 在左边比较并确认最终的位置
 * <p/>
 * <p/>
 * 第1次排序的结果=[1, 3, 2, 5, 4]
 * 第2次排序的结果=[1, 2, 3, 5, 4]
 * 第3次排序的结果=[1, 2, 3, 5, 4]
 * 第4次排序的结果=[1, 2, 3, 4, 5]
 *
 * 插入排序原理:
 *  a 将数组分为两部分, 将后部分的第一张逐一与前部分每一张比较, 如果当前元素小, 就移动被比较元素.
    b 找到合理位置插入.

 */
public class InsertSort {
    static int a;
    static int b;

    static int a1;
    static int b1;

    private static Logger logger = LoggerFactory.getLogger(InsertSort.class);

    public static void main(String[] args) {
        int[] array1 = {3, 1, 2, 5, 4};
        insertSort(array1);
        System.err.println("----------------------------------------------------------------");
        System.err.println(Arrays.toString(array1));


    }

    public static void insertSort(int[] ary) {
        int sortedIndex, wait_sort_element;

        for (int i = 1; i < ary.length; i++) {

            wait_sort_element = ary[i];//取出i对应的元素

            for (sortedIndex = i - 1; sortedIndex >= 0
                    && wait_sort_element < ary[sortedIndex]; sortedIndex--) {//比较元素 t<[j]
                ary[sortedIndex + 1] = ary[sortedIndex];//向后移动
                b++;
                logger.info("第{}次移动后的结果={}", b, Arrays.toString(ary));
            } // for循环结束的时候还会再次  sortedIndex--,所以 插入的位置 +1

            ary[sortedIndex + 1] = wait_sort_element;//找到插入位置j+1, 插入t
            a++;
            logger.info("第{}次排序的结果={}", a, Arrays.toString(ary));
        }
    }


}
