package com.leetcode.easy.array;

public class _643_Maximum_Average_Subarray_I {
    public double findMaxAverage(int[] nums, int k) {
        double s = 0;
        for (int i = 0; i < k; i++) {
            s += nums[i];
        }
        double a = s / k;

        for (int i = 1; i + k <= nums.length; i++) {
            s -= nums[i - 1];
            s += nums[i + k - 1];
            a = Math.max(a, s / k);
        }
        return a;
    }
}
