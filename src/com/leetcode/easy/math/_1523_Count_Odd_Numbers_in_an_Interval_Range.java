package com.leetcode.easy.math;

public class _1523_Count_Odd_Numbers_in_an_Interval_Range {
    //https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/

    public int countOdds(int low, int high) {
        if (low - high == 1) return 1;
        if (low == high) return 0;
        int c = 0;
        if (low % 2 == 0) c++;

        return (high - low) - ((high - low) / 2 + c);
    }
}
