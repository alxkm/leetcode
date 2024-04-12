package com.leetcode.medium.math;

public class _1492_The_kth_Factor_of_n {
    //1492. The kth Factor of n
    //https://leetcode.com/problems/the-kth-factor-of-n/

    public int kthFactor(int n, int k) {
        for (int i = 1, j = 0; i <= n; i++) {
            if (n % i == 0) {
                j++;
                if (k == j) return i;
            }
        }
        return -1;
    }
}
