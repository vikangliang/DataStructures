package search;

/**
 * 线性查找
 */
public class SeqSearch {
    public static void main(String args[]) {
        int arr[] = {1, 9, -1, 34, 3, 9};
        System.out.println(seqSearch(arr,3));
    }

    public static int seqSearch(int arr[], int values) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == values) {
                return i;
            }
        }
        return -1;
    }
}
