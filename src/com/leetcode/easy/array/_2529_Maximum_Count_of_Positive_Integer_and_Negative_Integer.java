package com.leetcode.easy.array;

public class _2529_Maximum_Count_of_Positive_Integer_and_Negative_Integer {
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
}
