package com.leetcode.easy.array;

public class _2733_Neither_Minimum_nor_Maximum {
    //2733. Neither Minimum nor Maximum
    //https://leetcode.com/problems/neither-minimum-nor-maximum/description/

    public int findNonMinOrMax(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int n: nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        for (int n: nums) {
            if (n != min && n != max) {
                return n;
            }
        }
        return -1;
    }
}
