package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String args[]) {
        int arr[] = {3, 9, -1, 10, 2, 0, 8};
        bubbleSort(arr);

        /**       int temp = 0;//临时变量
         //        第一趟排序，找出最大，放在后面
         for (int i = 0; i < arr.length - 1 - 0; i++) {
         //            后面的数比前面的大
         if (arr[i + 1] < arr[i]) {
         temp = arr[i + 1];
         arr[i + 1] = arr[i];
         arr[i] = temp;
         }
         }
         System.out.println("第一趟排序：");
         System.out.println(Arrays.toString(arr));


         //        第二趟排序，找出最大，放在后面
         for (int i = 0; i < arr.length - 1 - 1; i++) {
         //            后面的数比前面的大
         if (arr[i + 1] < arr[i]) {
         temp = arr[i + 1];
         arr[i + 1] = arr[i];
         arr[i] = temp;
         }
         }
         System.out.println("第二趟排序：");
         System.out.println(Arrays.toString(arr));

         //        第三趟排序，找出最大，放在后面
         for (int i = 0; i < arr.length - 1 - 2; i++) {
         //            后面的数比前面的大
         if (arr[i + 1] < arr[i]) {
         temp = arr[i + 1];
         arr[i + 1] = arr[i];
         arr[i] = temp;
         }
         }
         System.out.println("第三趟排序：");
         System.out.println(Arrays.toString(arr));

         //        第四趟排序，找出最大，放在后面
         for (int i = 0; i < arr.length - 1 - 3; i++) {
         //            后面的数比前面的大
         if (arr[i + 1] < arr[i]) {
         temp = arr[i + 1];
         arr[i + 1] = arr[i];
         arr[i] = temp;
         }
         }
         System.out.println("第四趟排序：");
         System.out.println(Arrays.toString(arr));**/
    }

    public static void bubbleSort(int arr[]) {
        // 整合前面代码为
        int temp = 0;
        boolean flag = false;//标识符，表示是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    flag = true;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "趟排序：");
            System.out.println(Arrays.toString(arr));
            if (flag == false) {//在一次交换中一次都没有发生
                break;
            } else {//flag==true,发生过交换
                flag = false;
            }
        }
    }
}




