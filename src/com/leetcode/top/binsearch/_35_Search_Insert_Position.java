package com.leetcode.top.binsearch;

public class _35_Search_Insert_Position {
    //https://leetcode.com/problems/search-insert-position/

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l + 1 < r) {
            int m = (l + r) / 2;
            if (nums[m] == target) return m;
            if (target <= nums[m]) {
                r = m;
            } else {
                l = m;
            }
        }
        if (target <= nums[l]) return l;
        return l + 1;
    }
}
