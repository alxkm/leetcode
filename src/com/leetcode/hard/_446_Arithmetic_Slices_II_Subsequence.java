package com.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class _446_Arithmetic_Slices_II_Subsequence {
    //446. Arithmetic Slices II - Subsequence
    //https://leetcode.com/problems/arithmetic-slices-ii-subsequence/description/

    public int numberOfArithmeticSlices(int[] nums) {
        Map<Integer, Integer>[] dp = new HashMap[nums.length];
        for (int i = 0; i < nums.length; i++) dp[i] = new HashMap<Integer, Integer>();

        //dp[i][diff] number of arithmetic subsequences end in i-th index
        int s = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                long diffLong = (long)nums[i] - nums[j];
                if (diffLong < Integer.MIN_VALUE || diffLong > Integer.MAX_VALUE) continue;

                int diff = (int) diffLong;
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + 1);
                if (dp[j].containsKey(diff)) {
                    dp[i].put(diff, dp[i].get(diff) + dp[j].get(diff));
                    s += dp[j].getOrDefault(diff, 0);
                }

            }
        }

        return s;
    }
}
