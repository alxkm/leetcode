package com.leetcode.medium.binsearch;

public class _33_Search_in_Rotated_Sorted_Array {
    //https://leetcode.com/problems/search-in-rotated-sorted-array/
    //33. Search in Rotated Sorted Array

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] == target) return m;

            if (nums[l] <= nums[m]) {
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return -1;
    }

    public int search1(int[] nums, int target) {
        if ((nums.length == 1 && target == nums[0]) || nums[0] == target) return 0;
        if (nums[nums.length - 1] == target) return nums.length - 1;
        int i = -1;
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (target == nums[m]) return m;

            if (nums[l] <= nums[m]) {
                if (target >= nums[l] && target <= nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] <= target && nums[r] >= target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return i;
    }
}
