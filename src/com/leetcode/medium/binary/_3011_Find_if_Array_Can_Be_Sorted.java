package com.leetcode.medium.binary;

import java.util.Arrays;

public class _3011_Find_if_Array_Can_Be_Sorted {
    //3011. Find if Array Can Be Sorted
    //https://leetcode.com/problems/find-if-array-can-be-sorted/description/

    public boolean canSortArray(int[] nums) {
        int[] vals = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (vals[j] < vals[j + 1]) continue;
                else {
                    if (Integer.bitCount(vals[j]) == Integer.bitCount(vals[j + 1])) {
                        int temp = vals[j];
                        vals[j] = vals[j + 1];
                        vals[j + 1] = temp;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
