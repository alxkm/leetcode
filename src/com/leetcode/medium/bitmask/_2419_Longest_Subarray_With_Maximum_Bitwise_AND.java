package com.leetcode.medium.bitmask;

import java.util.Arrays;

public class _2419_Longest_Subarray_With_Maximum_Bitwise_AND {
    //2419. Longest Subarray With Maximum Bitwise AND
    //https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/description/

    //tle
    public int longestSubarray(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int l = 1;
        int curLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                curLength++;
                l = Math.max(l, curLength);
            } else {
                curLength = 0;
            }
        }
        return l;
    }
}
