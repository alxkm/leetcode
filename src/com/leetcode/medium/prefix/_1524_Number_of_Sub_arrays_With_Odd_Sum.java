package com.leetcode.medium.prefix;

public class _1524_Number_of_Sub_arrays_With_Odd_Sum {
    //1524. Number of Sub-arrays With Odd Sum
    //https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/description/

    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int count = 0, prefixSum = 0;
        int oddCount = 0, evenCount = 1;

        for (int num : arr) {
            prefixSum += num;
            if (prefixSum % 2 == 0) {
                count += oddCount;
                evenCount++;
            } else {
                count += evenCount;
                oddCount++;
            }
            count %= MOD;
        }
        return count;
    }
}
