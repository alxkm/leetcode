package com.leetcode.easy.prefix;

import java.util.Arrays;

public class _2485_Find_the_Pivot_Integer {

    static public int pivotInteger(int n) {
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = 1;
        for (int i = 2; i < n; i++) {
            prefix[i - 1] = prefix[i - 2] + i;
        }
        suffix[0] = n;
        for (int i = n - 1; i >= 1; i--) {
            suffix[n - i] = suffix[n - i - 1] + i;
        }
        int result = -1;
        System.out.println(Arrays.toString(suffix));
        System.out.println(Arrays.toString(prefix));
        for (int i = 0; i < n; i++) {
            if (prefix[i] == suffix[n - i - 1]) {
                result = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(pivotInteger(8));
    }
}
