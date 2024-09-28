package com.leetcode.easy.bit;

public class _231_Power_of_Two {
    //231. Power of Two
    //https://leetcode.com/problems/power-of-two/

    public boolean isPowerOfTwo(int n) {
        if (n == 0 || n < 0) return false;
        return (n & (n - 1)) == 0;
    }
}
