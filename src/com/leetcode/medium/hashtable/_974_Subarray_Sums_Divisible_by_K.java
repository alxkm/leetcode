package com.leetcode.medium.hashtable;

public class _974_Subarray_Sums_Divisible_by_K {
    //974. Subarray Sums Divisible by K
    //https://leetcode.com/problems/subarray-sums-divisible-by-k/description/

    public int subarraysDivByK(int[] nums, int k) {
        int sumCounter = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) sumCounter++;
            }
        }
        return sumCounter;
    }
}
