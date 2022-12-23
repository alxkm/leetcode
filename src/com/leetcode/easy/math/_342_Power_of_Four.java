package com.leetcode.easy.math;

public class _342_Power_of_Four {
    public boolean isPowerOfFour(int n) {
        if (n == 1) return true;
        if (n <= 0) return false;

        while (n / 4 > 0) {
            if (n % 4 != 0) return false;
            n /= 4;
        }

        return n == 1;
    }
}
