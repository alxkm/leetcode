package com.leetcode.medium.prefix;

import com.leetcode.ArrayUtil;

public class _2270_Number_of_Ways_to_Split_Array {
    //2270. Number of Ways to Split Array
    //https://leetcode.com/problems/number-of-ways-to-split-array/description/?envType=daily-question&envId=2025-01-03

    public int waysToSplitArray(int[] nums) {
        long totalSum = 0;
        for (int n: nums) totalSum += n;

        long prefixSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            prefixSum += nums[i];
            long suffixSum = totalSum - prefixSum;
            if (prefixSum >= suffixSum) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        var sol = new _2270_Number_of_Ways_to_Split_Array();
        System.out.println(sol.waysToSplitArray(ArrayUtil.of(6,-1,9)));
        System.out.println(sol.waysToSplitArray(ArrayUtil.of(0, 0)));
        System.out.println(sol.waysToSplitArray(ArrayUtil.of(2,3,1,0)));
    }
}
