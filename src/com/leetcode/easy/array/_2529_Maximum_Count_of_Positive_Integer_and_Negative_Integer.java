package com.leetcode.easy.array;

public class _2529_Maximum_Count_of_Positive_Integer_and_Negative_Integer {
    //2529. Maximum Count of Positive Integer and Negative Integer
    //https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/

    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        for (int n: nums) {
            if (n > 0) pos++;
            else if (n < 0) neg++;
        }
        return Math.max(pos, neg);
    }

    public int maximumCount1(int[] nums) {
        int min = 0, max = 0;
        for (int n: nums) {
            if (n < 0) min++;
            else if (n > 0) max++;
        }
        return Math.max(min, max);
    }
}
