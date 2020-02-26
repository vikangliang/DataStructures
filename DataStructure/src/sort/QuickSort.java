package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String args[]) {
        int arr[] = {6, 1, 0,2};
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int arr[], int left, int right) {
        int l = left;
        int r = right;
        int temp = 0;
//        中轴值
        int pivot = arr[(left + right) / 2];
//        让左边都是比中轴值小的数，右边都是比中轴值大的数
        while (l < r) {
//            左边找到比中轴值小的数的小标
            while (arr[l] < pivot) {
                l = l + 1;
            }
//            右边找到比中轴值大的下标
            while (arr[r] > pivot) {
                r = r - 1;
            }
//            说明左边已经比中轴小，右边已经比中轴大了
            if (l >= r) {
                break;
            }
//            交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot) {
                r = r - 1;
            }
            if (arr[r] == pivot) {
                l = l + 1;
            }
            if (left < r) {
                quickSort(arr, left, r);
            }
            if (right > l) {
                quickSort(arr, l, right);
            }
        }
    }


    public static void quickSort2(int arr[], int left, int right) {
        if (left > right) {
            return;
        }
        int i = left, j = right;
        int temp = arr[left];
        while (i < j) {
            while (arr[j] >= temp && i < j) {
                j--;
            }
            while (arr[i] <= temp && i < j) {
                i++;
            }
            if (i < j) {
                int t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort2(arr, left, j - 1);
        //递归调用右半数组
        quickSort2(arr, j + 1, right);


    }
}
