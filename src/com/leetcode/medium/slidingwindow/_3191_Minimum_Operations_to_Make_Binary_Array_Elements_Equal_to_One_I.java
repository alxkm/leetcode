package com.leetcode.medium.slidingwindow;

public class _3191_Minimum_Operations_to_Make_Binary_Array_Elements_Equal_to_One_I {
    //https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/?envType=daily-question&envId=2025-03-19
    //3191. Minimum Operations to Make Binary Array Elements Equal to One I

    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] != 1) {
                nums[i] = 1;
                nums[i + 1] = (nums[i + 1] != 1 ? 1 : 0);
                nums[i + 2] = (nums[i + 2] != 1 ? 1 : 0);
                count++;
            }
        }
        for (int n: nums) {
            if (n != 1) return -1;
        }
        return count;
    }
}
