package com.leetcode.easy.array;

public class _1995_Count_Special_Quadruplets {
    //1995. Count Special Quadruplets
    //https://leetcode.com/problems/count-special-quadruplets/description/

    public int countQuadruplets(int[] nums) {
        int count = 0;
        for (int d = nums.length - 1; d >= 3; d--) {
            for (int c = d - 1; c >= 2; c--) {
                for (int b = c - 1; b >= 1; b--) {
                    for (int a = b - 1; a >= 0; a--) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
