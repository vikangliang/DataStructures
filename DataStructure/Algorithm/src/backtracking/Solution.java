package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 字符串的排列（回溯法）
 */
public class Solution {
    static ArrayList<String> res = new ArrayList<>();
    static TreeSet<String> treeSet = new TreeSet<>();
    static StringBuilder stringBuilder = new StringBuilder();
    static  boolean[] visited;

    public static void main(String args[]){
        String str="abc";
        Permutation(str);
        InversePairs(new int[]{7, 5, 6, 4});
    }

    public static ArrayList<String> Permutation(String str) {
        if (str == null || str.equals("")) {
            return res;
        }
        char[] strs = str.toCharArray();
        Arrays.sort(strs);
        visited = new boolean[strs.length];
        combination(strs, 0);
        res.addAll(treeSet);
        return res;
    }

    private static void combination(char[] strs, int len) {
        if (len == strs.length) {
            treeSet.add(stringBuilder.toString());
            return;
        }
        for (int i = 0; i < strs.length; i++) {
            if (!visited[i]) {
                visited[i]=true;
                stringBuilder.append(strs[i]);
                combination(strs, len + 1);
                //Duang ~ 回溯 - 状态重置
                visited[i] = false;
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }

    public static int InversePairs(int [] array) {
        if(array==null||array.length==0) return 0;
        int count=0;
        boolean flag=false;
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j+1]<array[j]){
                    flag=true;
                    count++;
                    int temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
            if(flag==false){
                break;
            }else{
                flag=false;
            }
        }
        System.out.println(Arrays.toString(array)+count);
        return count%1000000007;
    }
}
