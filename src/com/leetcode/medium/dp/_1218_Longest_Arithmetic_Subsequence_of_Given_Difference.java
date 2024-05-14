package com.leetcode.medium.dp;

import java.util.HashMap;
import java.util.Map;

public class _1218_Longest_Arithmetic_Subsequence_of_Given_Difference {
    //1218. Longest Arithmetic Subsequence of Given Difference
    //https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/description/

    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int max = 1;
        for (int n: arr) {
            dp.put(n, dp.getOrDefault(n - difference, 0) + 1);
            max = Math.max(max, dp.get(n));
        }
        return max;
    }
}
