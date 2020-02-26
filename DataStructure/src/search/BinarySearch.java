package search;

import java.util.ArrayList;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String args[]) {
        int arr[] = {1, 9, 10, 89, 1000,1000};
        System.out.println(binarySearch2(arr, 0, arr.length - 1, 1000));
    }

    public static int binarySearch(int arr[], int left, int right, int finalVal) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (finalVal > arr[mid]) {
            return binarySearch(arr, mid + 1, right, finalVal);
        } else if (finalVal < arr[mid]) {
            return binarySearch(arr, left, mid - 1, finalVal);
        } else {
            return mid;
        }
    }

    public static ArrayList binarySearch2(int arr[], int left, int right, int finalVal) {
        if (left > right) {
            return new ArrayList();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (finalVal > arr[mid]) {
            return binarySearch2(arr, mid + 1, right, finalVal);
        } else if (finalVal < arr[mid]) {
            return binarySearch2(arr, left, mid - 1, finalVal);
        } else {
            ArrayList<Integer> list = new ArrayList();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != finalVal) {
                    break;
                }
                list.add(temp);
                temp--;
            }
            list.add(mid);


            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != finalVal) {
                    break;
                }
                list.add(temp);
                temp++;
            }
            return list;
        }
    }
}
