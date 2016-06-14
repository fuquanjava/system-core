package data.struct.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] data = new int[]{6, 5, 4, 3, 2, 1};
        int[] tmp = new int[data.length];
        sort(data, 0, data.length - 1, tmp);

        System.out.println(Arrays.toString(data));
    }

    public static void sort(int[] arrays, int lo, int hi, int[] tmp) {
        if (lo < hi) {

            int mid = (lo + hi) >> 1; // 取中

            sort(arrays, lo, mid, tmp);

            sort(arrays, mid + 1, hi, tmp);

            merge(arrays, lo, mid, hi, tmp);
        }
    }

    /**
     * @param ary      待排序的数组
     * @param left     左边的起始位置
     * @param mid      右边的起始位置（也是中点位置)
     * @param rightEnd 右边结束为止
     * @param tmp      临时数组
     */
    private static void merge(int[] ary, int left, int mid, int rightEnd, int[] tmp) {
        int leftEnd = mid - 1; // 左边的结束位置
        int totalElements = rightEnd - left + 1; // 总共待排序的的元素
        int tmpStartIndex = left;
        while (left <= leftEnd && mid <= rightEnd) {
            if (ary[left] <= ary[mid]) {
                tmp[tmpStartIndex++] = ary[left++];
            } else {
                tmp[tmpStartIndex++] = ary[mid++];
            }
        }

        // left--leftEnd 或者 mid -- rightEnd 中有元素没有复制完毕

        // 复制左边剩余的元素到 tmp
        while (left <= leftEnd) {
            tmp[tmpStartIndex++] = ary[left++];
        }

        // 复制右边剩余的元素到 tmp
        while (mid <= rightEnd) {
            tmp[tmpStartIndex++] = ary[mid++];
        }

        // 复制完毕之后 需要把 tmp中的元素还原到 ary 中。
        for (int i = 0; i < totalElements; i++, rightEnd--) {
            ary[rightEnd] = tmp[rightEnd];
        }


    }
}
