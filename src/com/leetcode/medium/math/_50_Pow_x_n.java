package com.leetcode.medium.math;

public class _50_Pow_x_n {
    public double myPow(double x, int n) {
        if (x == 0  || x == -2147483648 || x == Integer.MAX_VALUE) return 0;
        if (x == 1) return 1;
        if (n == 1) return x;
        if (n == 0) return 1;
        if (n == -2147483648 && x < 0) return x*-1;
        if (n == -2147483648) return 0;
        if (n == 2147483647) return x;
        int initn = n;
        if (initn < 0) {
            n *= -1;
        }
        double result = x;
        while (n > 1) {
            result *= x;
            n--;
        }
        System.out.println(result);
        if (initn < 0) {
            return 1 / result;
        }
        return result;
    }
}
