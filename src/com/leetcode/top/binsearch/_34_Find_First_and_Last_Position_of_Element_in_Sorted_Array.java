package com.leetcode.top.binsearch;

public class _34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    //34. Find First and Last Position of Element in Sorted Array

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int l = 0;
        int r = nums.length;
        int m = 0;
        while (l + 1 < r) {
            m = l + (r - l) / 2;
            if (nums[m] > target) {
                r = m;
            } else {
                l = m;
            }
        }
        System.out.println(l);
        if (nums[l] != target) {
            return new int[]{-1, -1};
        }
        r = l;

        while (r + 1 < nums.length && nums[r + 1] == target) {
            r++;
        }

        while (l - 1 >= 0 && nums[l - 1] == target) {
            l--;
        }

        return new int[] {l, r};
    }
}
