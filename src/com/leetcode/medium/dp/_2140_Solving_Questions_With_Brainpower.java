package com.leetcode.medium.dp;

import java.util.Arrays;

public class _2140_Solving_Questions_With_Brainpower {
    //https://leetcode.com/problems/solving-questions-with-brainpower/description/?envType=daily-question&envId=2025-04-01
    //2140. Solving Questions With Brainpower

    int[][] q;
    long[] dp = new long[1_00_001];

    public long mostPoints(int[][] questions) {
        q = questions;
        Arrays.fill(dp, -1);
        return f(0);
    }

    private long f(int i) {
        if (i >= q.length) return 0;
        if (dp[i] != -1) return dp[i];

        long take = q[i][0] + f(i + q[i][1] + 1);
        long skip = f(i + 1);

        return dp[i] = Math.max(take, skip);
    }
}
