package com.leetcode.easy.dp;

public class _70_Climbing_Stairs {
    //70. Climbing Stairs
    //https://leetcode.com/problems/climbing-stairs/

    public int climbStairs(int n) {
        int dp = 0;
        int f = 1, s = 1;
        if (n == 1) return 1;
        for (int i = 1; i < n; i++) {
            dp = f + s;
            int temp = f;
            f = s;
            s = temp + f;
        }
        return dp;
    }

    public int climbStairs1(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <=n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
