package com.leetcode.easy.top;

public class _2873_Maximum_Value_of_an_Ordered_Triplet_I {
    //https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/
    //2873. Maximum Value of an Ordered Triplet I

    public long maximumTripletValue(int[] nums) {
        long max = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    max = Math.max(max, ((long)(nums[i] - nums[j])) * (long)nums[k]);
                }
            }
        }

        return max;
    }

    //foreign
    class Solution {
        public long maximumTripletValue(int[] nums) {
            long res = 0;
            long maxDiff = 0;
            long maxNum = 0;

            for(int num : nums) {
                res = Math.max(res, maxDiff * num);  // k
                maxDiff = Math.max(maxDiff, maxNum - num); // j
                maxNum = Math.max(maxNum, num); // i
            }

            return res;
        }
    }

    public long maximumTripletValue1(int[] nums) {
        long max = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    max = Math.max(max, ((long)(nums[i] - nums[j])) * (long)nums[k]);
                }
            }
        }

        return max;
    }
}
