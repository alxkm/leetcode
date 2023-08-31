package com.leetcode.medium.math;

public class _172_Factorial_Trailing_Zeroes {
    //https://leetcode.com/problems/factorial-trailing-zeroes/

    public int trailingZeroes(int n) {
        if (n < 5) return 0;
        int counter = 0;
        int i = 5;
        while (n / i != 0) {
            counter += (n / i);
            i *= 5;
        }
        return counter;
    }
}
