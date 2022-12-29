package com.leetcode.easy.prefix;

public class _303_Range_Sum_Query_Immutable {
    class NumArray {
        private int[] nums;
        private int[] prefix;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.prefix = new int[nums.length];
            this.prefix[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                prefix[i] += nums[i] + prefix[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            int prev = (left != 0 ? prefix[left - 1] : 0);
            return prefix[right] - prev;
        }
    }
}
