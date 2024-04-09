package com.leetcode.medium.dp;

public class _1143_Longest_Common_Subsequence {
    //1143. Longest Common Subsequence
    //https://leetcode.com/problems/longest-common-subsequence/

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
