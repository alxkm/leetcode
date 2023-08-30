package com.leetcode.medium.binsearch;

public class _540_Single_Element_in_a_Sorted_Array {
    //https://leetcode.com/problems/single-element-in-a-sorted-array/

    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = (l + r) / 2;
            if (m % 2 == 1) {
                m--;
            }
            if (nums[m] != nums[m + 1]) {
                r = m;
            } else {
                l = m + 2;
            }
        }
        return nums[l];
    }
}
