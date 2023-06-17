package com.leetcode.easy.array;

public class _2475_Number_of_Unequal_Triplets_in_Array {
    //https://leetcode.com/problems/number-of-unequal-triplets-in-array/

    public int unequalTriplets(int[] nums) {
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] != nums[j]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[j] != nums[k] && nums[i] != nums[k]) counter++;
                    }
                }
            }
        }

        return counter;
    }
}
