package com.leetcode.easy.array;

public class _1920_Build_Array_from_Permutation {
    public int[] buildArray(int[] nums) {
        int[] n = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            n[i] = nums[nums[i]];
        }
        return n;
    }
}
