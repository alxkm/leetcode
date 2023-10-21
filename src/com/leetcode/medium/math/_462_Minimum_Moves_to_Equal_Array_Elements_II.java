package com.leetcode.medium.math;

import java.util.Arrays;

public class _462_Minimum_Moves_to_Equal_Array_Elements_II {
    //https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
    //462. Minimum Moves to Equal Array Elements II

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int median = nums[nums.length / 2];
        for (int i = 0; i < nums.length; i++) {
            ans += Math.abs(nums[i] - median);
        }
        return ans;
    }
}
