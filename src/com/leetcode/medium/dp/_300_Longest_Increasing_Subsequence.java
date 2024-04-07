package com.leetcode.medium.dp;

public class _300_Longest_Increasing_Subsequence {
    //https://leetcode.com/problems/longest-increasing-subsequence/
    //300. Longest Increasing Subsequence
    //DP
    //FOREIGN_SOLUTION
    //LCS

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
