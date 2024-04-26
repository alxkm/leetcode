package com.leetcode.easy.dp;

public class _1137_N_th_Tribonacci_Number {
    //1137. N-th Tribonacci Number
    //https://leetcode.com/problems/n-th-tribonacci-number/

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

    public int tribonacci1(int n) {
        int t0 = 0, t1 = 1, t2 = 1;
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 2;

        for (int i = 3; i <= n; i++) {
            int t = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = t;
        }

        return t2;
    }
}
