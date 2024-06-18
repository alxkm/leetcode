package com.leetcode.medium.twopointers;

public class _633_Sum_of_Square_Numbers {
    //633. Sum of Square Numbers
    //https://leetcode.com/problems/sum-of-square-numbers

    public boolean judgeSquareSum(int c) {
        for (long i = 0, j = ((long)Math.sqrt(c)); i <= j; ) {
            long a = i * i + j * j;
            if (a == c) return true;
            if (a > c) j--;
            else i++;

        }
        return false;
    }
}
