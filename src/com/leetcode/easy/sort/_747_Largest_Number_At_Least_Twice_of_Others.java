package com.leetcode.easy.sort;

public class _747_Largest_Number_At_Least_Twice_of_Others {
    public int dominantIndex(int[] nums) {
        int index = 0;
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int a = Math.max(nums[i], max);
            if (a != max) {
                max = nums[i];
                index = i;
            }
        }
        int counter = 0;
        for (int num : nums) {
            if (num * 2 <= max) {
                counter++;
            }
        }

        if (counter == nums.length - 1) {
            return index;
        }

        return -1;
    }
}
