package com.leetcode.easy.simulation;

public class _2894_Divisible_and_Non_divisible_Sums_Difference {
    //2894. Divisible and Non-divisible Sums Difference
    //https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/

    public int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m != 0) num1 += i;
            if (i % m == 0) num2 += i;
        }
        return num1 - num2;
    }
}
