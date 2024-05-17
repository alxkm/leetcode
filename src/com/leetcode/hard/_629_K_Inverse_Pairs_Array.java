package com.leetcode.hard;

public class _629_K_Inverse_Pairs_Array {
    //629. K Inverse Pairs Array
    //https://leetcode.com/problems/k-inverse-pairs-array/description/
    //foreign

    public int kInversePairs(int n, int k) {
        if (n == 1 && k == 1) return 0;
        int[][] dp = new int[1001][1001];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int t = 0; t <= Math.min(j, i - 1); t++) {
                    if (j - t >= 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - t]) % 1000_000_007;
                    }
                }
            }
        }

        return dp[n][k];
    }
}
