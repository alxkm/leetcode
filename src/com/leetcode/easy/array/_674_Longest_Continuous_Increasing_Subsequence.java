package com.leetcode.easy.array;

public class _674_Longest_Continuous_Increasing_Subsequence {
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
