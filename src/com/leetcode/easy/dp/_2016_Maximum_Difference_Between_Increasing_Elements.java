package com.leetcode.easy.dp;

public class _2016_Maximum_Difference_Between_Increasing_Elements {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int max = 0;

        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            } else {
                max = Math.max(nums[i] - min, max);
            }
        }

        return max > 0 ? max : -1;
    }
}
