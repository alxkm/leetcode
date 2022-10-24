package com.leetcode.easy.dp;

public class _1869_Longer_Contiguous_Segments_of_Ones_than_Zeros {
    public boolean checkZeroOnes(String s) {
        int[] a = new int[s.length()];
        if (s.charAt(0) == '1') a[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') a[i] = a[i - 1] + 1;
        }

        int[] b = new int[s.length()];
        if (s.charAt(0) == '0') b[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') b[i] = b[i - 1] + 1;
        }
        int max = 0;
        int max1 = 0;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(max, a[i]);
            max1 = Math.max(max1, b[i]);
        }

        return max > max1;
    }
}
