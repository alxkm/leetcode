package com.leetcode.easy.enumeration;

import com.leetcode.ArrayUtil;

public class _2765_Longest_Alternating_Subarray {
    //2765. Longest Alternating Subarray
    //https://leetcode.com/problems/longest-alternating-subarray

    public int alternatingSubarray(int[] nums) {
        int size = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                int newSize = 2;
                boolean back = true;
                for (int j = i + 1; j < nums.length; j++) {
                    int curDiff = nums[j] - nums[j - 1];
                    if (back && curDiff == -1) {
                        back = false;
                    } else if (curDiff == 1) {
                        back = true;
                    } else {
                        i = j - 1;
                        break;
                    }
                    newSize++;
                }
                size = Math.max(size, newSize);
            }
        }
        return size;
    }

    public static void main(String[] args) {
        var sol = new _2765_Longest_Alternating_Subarray();
        sol.alternatingSubarray(ArrayUtil.of(2,3,4,3,4));
        sol.alternatingSubarray(ArrayUtil.of(42, 43, 44, 43, 44, 43, 44, 45, 46));
    }
}
