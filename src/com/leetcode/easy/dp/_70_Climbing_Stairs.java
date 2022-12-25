package com.leetcode.easy.dp;

public class _70_Climbing_Stairs {
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
}
