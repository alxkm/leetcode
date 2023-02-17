package com.leetcode.top;

public class _53_Maximum_Subarray {
    //https://leetcode.com/problems/maximum-subarray/
    //53. Maximum Subarray

    public int maxSubArray(int[] nums) {
        int s = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (s < 0) s = 0;
            s += nums[i];
            max = Math.max(s, max);
        }
        return max;
    }
}
