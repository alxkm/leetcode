package com.leetcode.medium.dp;

public class _1641_Count_Sorted_Vowel_Strings {
    //1641. Count Sorted Vowel Strings
    //https://leetcode.com/problems/count-sorted-vowel-strings/description/

    public int countVowelStrings(int n) {
        int a = 5;
        int e = 4;
        int i = 3;
        int o = 2;
        int u = 1;
        for (int j = 1; j < n; j++) {
            a = a + e + i + o + u;
            e = e + i + o + u;
            i = i + o + u;
            o = o + u;
            u = u;
        }
        return a;
    }
}
