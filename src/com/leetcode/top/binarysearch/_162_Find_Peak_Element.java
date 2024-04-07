package com.leetcode.top.binarysearch;

public class _162_Find_Peak_Element {
    //https://leetcode.com/problems/find-peak-element/
    //162. Find Peak Element
    //todo todo
    //binsearch

    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        if (nums.length == 0) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;

        while (l + 1 < r) {
            int m = (l + r) / 2;
            if (nums[m] > nums[m - 1]) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;
    }
}
