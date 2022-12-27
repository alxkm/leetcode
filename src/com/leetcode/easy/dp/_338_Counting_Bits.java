package com.leetcode.easy.dp;

public class _338_Counting_Bits {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        bits[0] = 0;
        if (n >= 1) bits[1] = 1;
        if (n >= 2) bits[2] = 1;
        for (int i = 0; i <= n; i++) {
            bits[i] = bits[i / 2] + i % 2;
        }
        return bits;
    }

    public int[] countBits1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        if (n == 0) return new int[]{0};
        if (n == 1) return new int[]{0, 1};

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i / 2] + i % 2;
        }
        return dp;
    }
}
