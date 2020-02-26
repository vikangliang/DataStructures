package binarysearchnorecursion;

/**
 * 二分查找非递归
 */
public class BinarySearchNoRecursion {
    public static void main(String args[]) {
        int arr[] = {1, 3, 8, 10, 11, 67, 100};
        System.out.println(binarySearch(arr, -8));
    }

    public static int binarySearch(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {//说明可以继续查找
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
