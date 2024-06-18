package com.leetcode.hard;

public class _330_Patching_Array {
    //330. Patching Array
    //https://leetcode.com/problems/patching-array/description/

    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int patches = 0;
        int i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss += miss;
                patches++;
            }
        }

        return patches;
    }
}
