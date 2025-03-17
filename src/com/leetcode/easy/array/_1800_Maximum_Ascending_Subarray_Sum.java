package com.leetcode.easy.array;

public class _1800_Maximum_Ascending_Subarray_Sum {
    //1800. Maximum Ascending Subarray Sum
    //https://leetcode.com/problems/maximum-ascending-subarray-sum/description/

    public int maxAscendingSum(int[] nums) {
        int a = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                a = a + nums[i];
            } else {
                a = nums[i];
            }
            max = Math.max(a, max);
        }
        return max;
    }
}
