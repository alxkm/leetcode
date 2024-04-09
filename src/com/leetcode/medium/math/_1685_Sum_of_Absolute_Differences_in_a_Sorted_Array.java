package com.leetcode.medium.math;

public class _1685_Sum_of_Absolute_Differences_in_a_Sorted_Array {
    //1685. Sum of Absolute Differences in a Sorted Array
    //https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];
        for (int i = 1, j = n - 2; i < n; i++, j--) {
            prefix[i] = prefix[i - 1] + nums[i];
            suffix[j] = suffix[j + 1] + nums[j];
        }
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ((nums[i] * i) - prefix[i]) + (suffix[i] - (nums[i] * (n - i - 1)));
        }
        return a;
    }
}
