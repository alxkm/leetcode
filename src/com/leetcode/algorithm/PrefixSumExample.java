package com.leetcode.algorithm;

import java.util.Arrays;

public class PrefixSumExample {

   static int[] findPrefix(int[] a) {
        int n = a.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + a[i];
        }
        return prefix;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] prefix = findPrefix(a);
        System.out.println(Arrays.toString(prefix));
        System.out.println(prefix[3] - prefix[1]);
        System.out.println();
    }
}
