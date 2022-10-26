package com.leetcode.easy.hash;

public class _2357_Make_Array_Zero_by_Subtracting_Equal_Amounts {
    public int minimumOperations(int[] nums) {
        int counter = 0;
        while (true) {
            int min = 10000000;

            for (int n : nums) {
                if (n != 0) {
                    min = Math.min(min, n);
                }
            }

            if (min == 10000000) return counter;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) nums[i] -= min;
            }

            counter++;
        }
    }
}
