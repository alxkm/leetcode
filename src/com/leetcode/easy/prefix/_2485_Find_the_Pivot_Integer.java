package com.leetcode.easy.prefix;

import java.util.Arrays;

public class _2485_Find_the_Pivot_Integer {
    //2485. Find the Pivot Integer
    //https://leetcode.com/problems/find-the-pivot-integer/

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

    public static int pivotInteger1(int n) {
        int[] pr = new int[n + 1];
        pr[1] = 1;
        for (int i = 1; i <= n; i++) {
            pr[i] = pr[i - 1] + i;
        }
        int pivot = -1;
        for (int i = 1; i <= n; i++) {
            if (pr[i] == pr[n] - pr[i - 1]) return i;
        }
        return pivot;
    }

    public static void main(String[] args) {
        System.out.println(pivotInteger1(8));
    }
}
