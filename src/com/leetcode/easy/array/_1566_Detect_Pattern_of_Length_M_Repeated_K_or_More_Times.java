package com.leetcode.easy.array;

public class _1566_Detect_Pattern_of_Length_M_Repeated_K_or_More_Times {
    //https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/

    public boolean containsPattern(int[] arr, int m, int k) {
        int c = 0;
        for (int i = 0, l = i + m; i < arr.length - m; i++) {
            if (arr[i] == arr[i + m]) {
                c++;
            } else {
                c = 0;
            }
            if (c == (k - 1) * m) {
                return true;
            }
        }
        return false;
    }
}
