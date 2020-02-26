package search;

import java.util.Arrays;

/**
 * 插值查找
 */
public class InsertValueSearch {
    public static void main(String args[]) {
        int arr[] = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
//        System.out.println(Arrays.toString(arr));
        System.out.println(insertValueSearch(arr,0,arr.length-1,100));
    }

    public static int insertValueSearch(int arr[], int left, int right, int value) {
//        必须有
        if (left > right || value < arr[0] || value > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if (value > midValue) {
            return insertValueSearch(arr, mid + 1, right, value);
        } else if (value < midValue) {
            return insertValueSearch(arr, left, mid - 1, value);
        } else {
            return mid;
        }
    }
}
