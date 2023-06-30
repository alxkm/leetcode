package com.leetcode.medium.array;

import java.util.Arrays;

public class _1877_Minimize_Maximum_Pair_Sum_in_Array {
    //https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = nums[0] + nums[1];
        for (int i = 0, j = nums.length - 1; i < nums.length / 2; i++, j--) {
            max = Math.max(nums[i] + nums[j], max);
        }
        return max;
    }
}
