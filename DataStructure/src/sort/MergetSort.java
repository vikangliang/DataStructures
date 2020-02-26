package sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergetSort {
    public static void main(String args[]) {
        int arr[] = {1, 1, 2, 4, 3, 5, 4, 6, 9};
        int temp[] = new int[arr.length];
        mergetSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    //分离
    public static void mergetSort(int arr[], int left, int right, int temp[]) {
        if (left < right) {
            int mid = (left + right) / 2;
//            左递归
            mergetSort(arr, left, mid, temp);
//            右递归
            mergetSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }


    /**
     * 治
     *
     * @param arr   原始数组
     * @param left  左边索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  中转数组
     */
    public static void merge(int arr[], int left, int mid, int right, int temp[]) {
        int i = left;//初始化左边
        int j = mid + 1;//初始化j,右边
        int t = 0;//temp当前索引

        while (i <= mid && j <= right) {//先把左右两边的数填充到temp
            if (arr[i] <= arr[j]) {//左边的数小于等于右边的，加入到temp，t,i后移
                temp[t] = arr[i];
                t++;
                i++;
            } else {//反之，把右边的加入temp
                temp[t] = arr[j];
                t++;
                j++;
            }

            while (i <= mid) {//左边还有剩余的元素，全部加入temp
                temp[t] = arr[i];
                t++;
                i++;
            }

            while (j <= right) {//右边还有剩余的元素，全部加入temp
                temp[t] = arr[j];
                t++;
                j++;
            }

//            将temp数组拷贝到arr
            t = 0;
            int tempLeft = left;
            while (tempLeft <= right) {
                arr[tempLeft] = temp[t];
                t++;
                tempLeft++;
            }
        }
    }
}
