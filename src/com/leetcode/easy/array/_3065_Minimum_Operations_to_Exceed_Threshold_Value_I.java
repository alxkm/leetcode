package com.leetcode.easy.array;

public class _3065_Minimum_Operations_to_Exceed_Threshold_Value_I {
    //3065. Minimum Operations to Exceed Threshold Value I
    //https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/description/

    public int minOperations(int[] nums, int k) {
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) counter++;
        }

        return counter;
    }
}
