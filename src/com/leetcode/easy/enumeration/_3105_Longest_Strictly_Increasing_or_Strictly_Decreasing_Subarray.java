package com.leetcode.easy.enumeration;

public class _3105_Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray {
    //3105. Longest Strictly Increasing or Strictly Decreasing Subarray
    //https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/

    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 1) return 1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int counter = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j - 1] >= nums[j]) break;
                counter++;
            }
            max = Math.max(max, counter);
        }
        for (int i = 0; i < nums.length; i++) {
            int counter = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j - 1] <= nums[j]) break;
                counter++;
            }
            max = Math.max(max, counter);
        }
        return max;
    }

    public int longestMonotonicSubarray1(int[] nums) {
        int asc = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j - 1] < nums[j]) {
                    asc = Math.max(asc, j - i + 1);
                } else {
                    i = j - 1;
                    break;
                }
            }
        }
        int des = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j - 1] > nums[j]) {
                    des = Math.max(des, j - i + 1);
                } else {
                    i = j - 1;
                    break;
                }
            }
        }

        return Math.max(asc, des);
    }
}
