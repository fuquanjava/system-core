package data.struct.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] data = new int[]{6, 5, 4, 3, 2, 1};
        sort(data, 0, data.length - 1 ,"描述");

        System.out.println(Arrays.toString(data));
    }

    public static void sort(int[] arrays, int lo, int hi , String desc) {
        System.err.println("lo:" + lo + ", hi:" + hi);
        if (lo >= hi) {
            System.out.println(desc+ " -- 退出条件 lo= " + lo + ", hi= " + hi);
            return;
        }
        int mid = (lo + hi) >> 1;
        // 左边排好序元素的位置.
        sort(arrays, lo, mid, "左边");

        //右边排好序元素的位置
        sort(arrays, mid + 1, hi, "右边");

        merge(arrays,lo, mid, hi);
    }

    /**
     * @param arrays 待排序的数组对象
     * @param lo   左数组的第一个元素的索引
     * @param mid    左数组的最后一个元素的索引，mid+1是右数组第一个元素的索引
     * @param hi  右数组最后一个元素的索引
     */
    private static void merge(int[] arrays, int lo, int mid, int hi) {
        int[] temp = new int[hi - lo + 1];
        int i = lo;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= hi) {
            if (arrays[i] < arrays[j]) {
                temp[k++] = arrays[i++];
            } else {
                temp[k++] = arrays[j++];
            }
        }

        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = arrays[i++];
        }

        // 把右边边剩余的数移入数组
        while (j <= hi) {
            temp[k++] = arrays[j++];
        }

        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            arrays[k2 + lo] = temp[k2];
        }

    }
}
