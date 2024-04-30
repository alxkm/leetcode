package com.leetcode.K_package;

public class _2444_Count_Subarrays_With_Fixed_Bounds {
    //2444. Count Subarrays With Fixed Bounds
    //https://leetcode.com/problems/count-subarrays-with-fixed-bounds/
    //hard
    //todo
    //foreign

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long counter = 0;
        int max = -1, min = -1;
        int s = nums.length;
        for (int r = 0, l = 0; r < s; r++) {
            int x = nums[r];
            if (x < minK || x > maxK) {
                l = r + 1;
                continue;
            }
            if (x == maxK) max = r;
            if (x == minK) min = r;
            counter += Math.max((Math.min(max, min) - l + 1), 0);
        }
        return counter;
    }
}
