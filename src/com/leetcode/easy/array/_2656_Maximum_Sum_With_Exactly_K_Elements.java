package com.leetcode.easy.array;

public class _2656_Maximum_Sum_With_Exactly_K_Elements {
    //2656. Maximum Sum With Exactly K Elements
    //https://leetcode.com/problems/maximum-sum-with-exactly-k-elements/description/

    public int maximizeSum(int[] nums, int k) {
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) prev = Math.max(nums[i], prev);
        int s = 0;

        for (int i = 0; i < k; i++) {
            s += prev;
            prev++;
        }
        return s;
    }
}
