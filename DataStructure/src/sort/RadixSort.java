package sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String args[]) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
    }

    public static void radixSort(int arr[]) {
        //        第一轮，针对每个元素的各位进行排序
        //        定义一个二维数组表示10个桶，每个桶就是一个一维数组
        //        为了防止放入数的溢出，每个桶的大小都设定为arr.length,为经典的空间换时间算法
        int bucket[][] = new int[10][arr.length];

        //        为记录每个桶放入数据个数，定义一个一维数组来保存
        int bucketElementCount[] = new int[10];

//        1.得到数组中最大的数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
//        2.得到最大数是几位数
        int maxLength = (max + "").length();

//        3.整合以下代码
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
//            针对每一轮排序
            for (int j = 0; j < arr.length; j++) {
                //            取出每个元素的对应位
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
                bucketElementCount[digitOfElement]++;
            }
//            System.out.println(Arrays.toString(bucket[][]));
            //        按照桶的顺序取出
            int index = 0;
            for (int k = 0; k < bucket.length; k++) {
                //            如果桶中有数据才放入原数组
                if (bucketElementCount[k] != 0) {
                    //                遍历该桶
                    for (int l = 0; l < bucketElementCount[k]; l++) {
                        //                    取出元素
                        arr[index++] = bucket[k][l];
                    }
                }
                //            第i轮处理后将数组清0
                bucketElementCount[k] = 0;
            }
            System.out.println("第" + (i + 1) + "轮" + Arrays.toString(arr));
        }
/**
 //        第一轮，针对每个元素的各位进行排序
 //        定义一个二维数组表示10个桶，每个桶就是一个一维数组
 //        为了防止放入数的溢出，每个桶的大小都设定为arr.length,为经典的空间换时间算法
 int bucket[][] = new int[10][arr.length];

 //        为记录每个桶放入数据个数，定义一个一维数组来保存
 int bucketElementCount[] = new int[10];

 for (int j = 0; j < arr.length; j++) {
 //            取出每个元素的个位
 int digitOfElement = arr[j] % 10;
 bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
 bucketElementCount[digitOfElement]++;
 }
 //        按照桶的顺序取出
 int index = 0;
 for (int k = 0; k < bucket.length; k++) {
 //            如果桶中有数据才放入原数组
 if (bucketElementCount[k] != 0) {
 //                遍历该桶
 for (int l = 0; l < bucketElementCount[k]; l++) {
 //                    取出元素
 arr[index++] = bucket[k][l];
 }
 }
 //            第一轮处理后将数组清0
 bucketElementCount[k] = 0;
 }

 System.out.println("第一轮" + Arrays.toString(arr));

 //        第二轮
 for (int j = 0; j < arr.length; j++) {
 //            取出每个元素的十位
 int digitOfElement = arr[j] / 10 % 10;
 bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
 bucketElementCount[digitOfElement]++;
 }
 //        按照桶的顺序取出
 index = 0;
 for (int k = 0; k < bucket.length; k++) {
 //            如果桶中有数据才放入原数组
 if (bucketElementCount[k] != 0) {
 //                遍历该桶
 for (int l = 0; l < bucketElementCount[k]; l++) {
 //                    取出元素
 arr[index++] = bucket[k][l];
 }
 }
 bucketElementCount[k] = 0;
 }

 System.out.println("第二轮" + Arrays.toString(arr));


 //        第三轮
 for (int j = 0; j < arr.length; j++) {
 //            取出每个元素的十位
 int digitOfElement = arr[j] / 100 % 10;
 bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
 bucketElementCount[digitOfElement]++;
 }
 //        按照桶的顺序取出
 index = 0;
 for (int k = 0; k < bucket.length; k++) {
 //            如果桶中有数据才放入原数组
 if (bucketElementCount[k] != 0) {
 //                遍历该桶
 for (int l = 0; l < bucketElementCount[k]; l++) {
 //                    取出元素
 arr[index++] = bucket[k][l];
 }
 }
 }

 System.out.println("第二轮" + Arrays.toString(arr));
 **/
    }
}
