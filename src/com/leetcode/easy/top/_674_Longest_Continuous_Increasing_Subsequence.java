package com.leetcode.easy.top;

public class _674_Longest_Continuous_Increasing_Subsequence {
    //https://leetcode.com/problems/longest-continuous-increasing-subsequence/
    //674. Longest Continuous Increasing Subsequence
    //easyTop

    public int findLengthOfLCIS(int[] nums) {
        int max = 1;
        int local = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                local++;
            } else {
                local = 1;
            }
            max = Math.max(max, local);
        }
        return max;
    }
}
