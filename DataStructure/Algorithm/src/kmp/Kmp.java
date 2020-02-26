package kmp;

import java.util.Arrays;

public class Kmp {

    public static void main(String args[]) {
        String s1 = "BBC ABCDAB ABCDABCDABDE";
        String s2 = "ABCDABD";
        System.out.println(kmpSearch(s1,s2,kmpNext(s2)));
        System.out.println(bf(s1, s2));
    }

    public static int kmpSearch(String s1, String s2, int next[]) {
//        遍历
        for (int i = 0, j = 0; i < s1.length(); i++) {
            while (j > 0 && s1.charAt(i) != s2.charAt(j)) {
                j = next[j - 1];
            }

            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
            if (j == s2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static int[] kmpNext(String s) {
        int next[] = new int[s.length()];
        next[0] = 0;//如果字符串长度是1，部分匹配值为0
        for (int i = 1, j = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }


    //蛮力法
    public static int bf(String s1, String s2) {
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();

        int len1 = c1.length;
        int len2 = c2.length;

        int i = 0;
        int j = 0;

        while (i < len1 && j < len2) {
            if (c1[i] == c2[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == len2) {
            return i - j;
        } else {
            return -1;
        }
    }
}
