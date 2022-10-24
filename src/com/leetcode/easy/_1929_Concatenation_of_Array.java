package com.leetcode.easy;

public class _1929_Concatenation_of_Array {
    class Solution {
        public int[] getConcatenation(int[] nums) {
            int[] ans = new int[nums.length * 2];
            for (int i = 0, j = 0; j < nums.length * 2; i++, j++) {
                ans[j] = nums[i];
                if (i == nums.length - 1) i = -1;
            }
            return ans;
        }
    }
}
