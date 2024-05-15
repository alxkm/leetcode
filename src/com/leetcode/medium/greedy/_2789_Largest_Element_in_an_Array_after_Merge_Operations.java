package com.leetcode.medium.greedy;

public class _2789_Largest_Element_in_an_Array_after_Merge_Operations {
    //2789. Largest Element in an Array after Merge Operations
    //https://leetcode.com/problems/largest-element-in-an-array-after-merge-operations/

    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long[] ar = new long[n];
        for (int i = 0; i < nums.length; i++) {
            ar[i] = nums[i];
        }
        if (n == 1) return ar[0];
        if (n == 2) {
            if (ar[0] <= ar[1]) return ar[0] + ar[1];
            else return ar[0];
        }
        long max = 0;
        for (int i = ar.length - 2; i >= 0; i--) {
            if (ar[i + 1] < ar[i]) continue;
            ar[i] = ar[i] + ar[i + 1];
            max = Math.max(max, ar[i]);
        }
        return Math.max(ar[0], max);
    }
}
