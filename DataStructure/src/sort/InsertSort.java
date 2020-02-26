package sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String args[]) {
        int arr[] = {17, 3, 25, 14};
        insertSort(arr);
/**
 //第一趟
 int insertVal = arr[1];
 int insertIndex = 1 - 1;
 while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
 arr[insertIndex + 1] = arr[insertIndex];
 insertIndex--;
 }
 arr[insertIndex + 1] = insertVal;
 System.out.println("第一趟");
 System.out.println(Arrays.toString(arr));


 //第二趟
 insertVal = arr[2];
 insertIndex = 2 - 1;
 while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
 arr[insertIndex + 1] = arr[insertIndex];
 insertIndex--;
 }
 arr[insertIndex + 1] = insertVal;
 System.out.println("第二趟");
 System.out.println(Arrays.toString(arr));


 //第三趟
 insertVal = arr[3];
 insertIndex = 3 - 1;
 while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
 arr[insertIndex + 1] = arr[insertIndex];
 insertIndex--;
 }
 arr[insertIndex + 1] = insertVal;
 System.out.println("第三趟");
 System.out.println(Arrays.toString(arr));**/
    }

    public static void insertSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i)
                arr[insertIndex + 1] = insertVal;
            System.out.println("第" + i + "趟");
            System.out.println(Arrays.toString(arr));
        }
    }
}
