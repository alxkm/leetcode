package com.leetcode.medium.prefix;

public class _2874_Maximum_Value_of_an_Ordered_Triplet_II {
    //2874. Maximum Value of an Ordered Triplet II
    //https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/description/

    public long maximumTripletValue(int[] nums) {
        long max = 0;

        int[] suffix = new int[nums.length + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            suffix[i] = Math.max(nums[i], suffix[i + 1]);
        }

        int[] prefix = new int[nums.length + 1];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = Math.max(nums[i], prefix[i - 1]);
        }

        for (int i = 1; i < nums.length - 1; i++) {
            max = Math.max(max, (long) (prefix[i - 1] - nums[i]) * (long) suffix[i + 1]);
        }
        return max;
    }

    public long maximumTripletValue1(int[] nums) {
        int len = nums.length;
        long res = 0;
        long imax = 0;
        long dmax = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dmax * nums[i]);
            dmax = Math.max(dmax, imax - nums[i]);
            imax = Math.max(imax, nums[i]);
        }
        return res;
    }
}
