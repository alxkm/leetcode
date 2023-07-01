package com.leetcode.medium.math;

import java.util.Arrays;

public class _1498_Number_of_Subsequences_That_Satisfy_the_Given_Sum_Condition {
    //https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        long n = 0;
        int mod = 1_000_000_007;
        long[] power = new long[nums.length];
        power[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            power[i] = (power[i - 1] << 1) % mod;
        }
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                n = (n + power[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return (int)n;
    }
}
