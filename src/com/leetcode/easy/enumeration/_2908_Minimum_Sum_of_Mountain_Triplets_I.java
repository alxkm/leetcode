package com.leetcode.easy.enumeration;

public class _2908_Minimum_Sum_of_Mountain_Triplets_I {
    //https://leetcode.com/problems/minimum-sum-of-mountain-triplets-i/
    //2908. Minimum Sum of Mountain Triplets I

    public int minimumSum(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] < nums[j]) {
                            min = Math.min(min, nums[i] + nums[j] + nums[k]);
                        }
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
