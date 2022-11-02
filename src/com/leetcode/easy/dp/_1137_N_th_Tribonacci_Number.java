package com.leetcode.easy.dp;

public class _1137_N_th_Tribonacci_Number {
    public int tribonacci(int n) {
        int n0 = 0;
        int n1 = 1;
        int n2 = 1;
        int nn = n0 + n1 + n2;

        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;

        for (int i = 3; i <= n; i++) {
            nn = n0 + n1 + n2;

            n0 = n1;
            n1 = n2;
            n2 = nn;
        }
        return nn;
    }
}
