package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String args[]) {
        int arr[] = {4, 6, 8, 5, 9};
        heapSort(arr);
    }

    public static void heapSort(int arr[]) {
        System.out.println("堆排序");
//        将无序序列构成一个堆，根据需求选择大顶堆或者小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
//            System.out.println(Arrays.toString(arr));
        }

        for (int j = arr.length - 1; j > 0; j--) {
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 完成将i所对应的非叶子节点的数调整成大顶堆
     *
     * @param arr    待调整数组
     * @param i      表示非叶子节点在数组中的位置
     * @param length 表示对多少个元素进行调整，是在逐渐减少
     */
    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];//先取出当前的值，保存在临时变量
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {//k是i的左子节点
            if (k + 1 < length && arr[k] < arr[k + 1]) {//左子节点小于右子节点
                k++;//指向右子节点
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];//把较大的赋给当前节点
                i = k;//i指向k，继续循环比较
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
