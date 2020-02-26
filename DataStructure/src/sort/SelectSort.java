package sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String args[]) {
        int arr[] = {101, 34, 119, 1, 5, -2, 9, 8, -7, 4};
        selectSort(arr);
        /**
         //        假定最小数为arr【0】
         //        第一趟
         int minIndex = 0;
         int min = arr[0];
         for (int i = 0 + 1; i < arr.length; i++) {
         if (min > arr[i]) {
         //                重置最小
         min = arr[i];
         minIndex = i;
         }
         }
         //交换
         if (minIndex != 0) {
         arr[minIndex] = arr[0];
         arr[0] = min;
         }
         System.out.println("第一趟：");
         System.out.println(Arrays.toString(arr));


         //        第二趟
         minIndex = 1;
         min = arr[1];
         for (int i = 1 + 1; i < arr.length; i++) {
         if (min > arr[i]) {
         //                重置最小
         min = arr[i];
         minIndex = i;
         }
         }
         //交换
         if (minIndex != 1) {
         arr[minIndex] = arr[1];
         arr[1] = min;
         }
         System.out.println("第二趟：");
         System.out.println(Arrays.toString(arr));


         //        第三趟
         minIndex = 2;
         min = arr[2];
         for (int i = 2 + 1; i < arr.length; i++) {
         if (min > arr[i]) {
         //                重置最小
         min = arr[i];
         minIndex = i;
         }
         }
         //交换
         if (minIndex != 2) {
         arr[minIndex] = arr[2];
         arr[2] = min;
         }
         System.out.println("第三趟：");
         System.out.println(Arrays.toString(arr));
         **/
    }

    public static void selectSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    //                重置最小
                    min = arr[j];
                    minIndex = j;
                }
            }
            //交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("第" + (i + 1) + "趟：");
            System.out.println(Arrays.toString(arr));
        }
    }
}
