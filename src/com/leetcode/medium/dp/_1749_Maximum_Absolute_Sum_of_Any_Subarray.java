package com.leetcode.medium.dp;

public class _1749_Maximum_Absolute_Sum_of_Any_Subarray {
    //https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/description/
    //1749. Maximum Absolute Sum of Any Subarray

    public int maxAbsoluteSum(int[] arr) {
        int cur = 0;
        int minPr = 0;
        int maxPr = 0;
        int res = 0;
        for (int n : arr) {
            cur += n;
            res = Math.max(res, Math.max(Math.abs(cur - minPr), Math.abs(cur - maxPr)));
            minPr = Math.min(minPr, cur);
            maxPr = Math.max(maxPr, cur);
        }
        return res;
    }
}
