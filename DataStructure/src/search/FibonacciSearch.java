package search;

import java.util.Arrays;

/**
 * 斐波那契查找
 */
public class FibonacciSearch {
    static int maxSize = 20;

    public static void main(String args[]) {
        int arr[] = {1, 8, 10, 89, 1000};
        System.out.println(fibSearch(arr, 89));
//        System.out.println(fibSearch2(arr, 0, arr.length - 1, 1000));
    }

    public static int[] fib() {
        int f[] = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * 斐波那契查找（非递归）
     *
     * @param arr
     * @param value
     */
    public static int fibSearch(int arr[], int value) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;//斐波那契分割数值下标
        int mid = 0;
        int f[] = fib();//获取斐波那契数列
        while (high >= f[k] - 1) {
            k++;
        }
//        因为f【k】可能大于a长度，需要构造一个新的数组
        int temp[] = Arrays.copyOf(arr, f[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (value < temp[mid]) {
                // 查找前半部分，高位指针移动
                // （全部元素） = （前半部分）+（后半部分）
                // f[k] = f[k-1] + f[k-1]
                // 因为前半部分有f[k-1]个元素，所以 k = k-1
                high = mid - 1;//排除右半边的元素
                k--;// f(k-1)是左半边的长度
            } else if (value > temp[mid]) {
                // 查找后半部分，高位指针移动
                low = mid + 1;//排除左半边的元素
                // （全部元素） = （前半部分）+（后半部分）
                // f[k] = f[k-1] + f[k-1]
                // 因为后半部分有f[k-2]个元素，所以 k = k-2
                k = k - 2;// f(k-2)是右半边的长度
            } else {
                if (mid <= high) { // 如果为真则找到相应的位置
                    return mid;
                } else {
                    // 出现这种情况是查找到补充的元素
                    // 而补充的元素与high位置的元素一样
                    return high;
                }
            }
        }
        return -1;
    }
}
