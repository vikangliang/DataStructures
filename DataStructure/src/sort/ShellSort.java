package sort;

import java.util.Arrays;

/**
 * 希尔排序（插入排序优化）
 */
public class ShellSort {
    public static void main(String args[]) {
        int arr[] = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort2(arr);
        /**
         int temp = 0;
         //        第一轮
         //        希尔排序把十个数分成五组
         for (int i = 5; i < arr.length; i++) {
         //            遍历各组中所有的元素
         for (int j = i - 5; j >= 0; j = j - 5) {
         //                如果当前元素大于加上步长后的元素，这说明需要交换
         if (arr[j] > arr[j + 5]) {
         temp = arr[j];
         arr[j] = arr[j + 5];
         arr[j + 5] = temp;
         }
         }
         }
         System.out.println("第一趟：");
         System.out.println(Arrays.toString(arr));


         //        第二轮
         //        希尔排序把十个数分成五/2=2组
         for (int i = 2; i < arr.length; i++) {
         //            遍历各组中所有的元素
         for (int j = i - 2; j >= 0; j = j - 2) {
         //                如果当前元素大于加上步长后的元素，这说明需要交换
         if (arr[j] > arr[j + 2]) {
         temp = arr[j];
         arr[j] = arr[j + 2];
         arr[j + 2] = temp;
         }
         }
         }
         System.out.println("第二趟：");
         System.out.println(Arrays.toString(arr));


         //        第三轮
         //        希尔排序把十个数分成2/2=1组
         for (int i = 1; i < arr.length; i++) {
         //            遍历各组中所有的元素
         for (int j = i - 1; j >= 0; j = j - 1) {
         //                如果当前元素大于加上步长后的元素，这说明需要交换
         if (arr[j] > arr[j + 1]) {
         temp = arr[j];
         arr[j] = arr[j + 1];
         arr[j + 1] = temp;
         }
         }
         }
         System.out.println("第三趟：");
         System.out.println(Arrays.toString(arr));
         **/
    }

    public static void shellSort(int arr[]) {
//整合上面代码
        int temp = 0;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            count++;
            for (int i = gap; i < arr.length; i++) {
//            遍历各组中所有的元素
                for (int j = i - gap; j >= 0; j = j - gap) {
//                如果当前元素大于加上步长后的元素，这说明需要交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("第" + count + "趟：");
            System.out.println(Arrays.toString(arr));
        }
    }

    //采用移位法
    public static void shellSort2(int arr[]) {
//整合上面代码
        int temp = 0;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            count++;
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j = j - gap;
                    }
                    arr[j] = temp;
                }
            }
            System.out.println("第" + count + "趟：");
            System.out.println(Arrays.toString(arr));
        }
    }
}
