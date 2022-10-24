package com.leetcode.easy;

import java.util.Arrays;

public class _283_Move_Zeroes {
    static public void moveZeroes(int[] nums) {
        boolean c = false;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0 ) {
                nums[j] = nums[i];
                if (c) nums[i] = 0;
                j++;
            } else {
                c = true;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println();
    }
}
