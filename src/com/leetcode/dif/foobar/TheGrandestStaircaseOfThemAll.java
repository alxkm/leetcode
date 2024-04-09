package com.leetcode.dif.foobar;

public class TheGrandestStaircaseOfThemAll {
    //dp

    public static int solution(int n) {
        int[][] dp = new int[n + 5][n + 5];
        dp[3][2] = dp[4][2] = 1;
        for (int i = 5; i <= n; i++) {
            for (int j = 2; j <= i; j++) {
                if (j == 2) {
                    dp[i][j] = dp[i - j][j] + 1;
                } else {
                    dp[i][j] = dp[i - j][j] + dp[i - j][j - 1];
                }
            }
        }

        int s = 0;
        for (int i = 1; i <= n; i++) {
            s = s + dp[n][i];
        }
        return s;
    }

    public static int solve(int h, int l) {
        if (l == 0) return 1;
        if (l < h) return 0;
        return solve(h + 1, l - h) + solve(h + 1, l);
    }

    public static void main(String[] args) {
        System.out.println(solution(200));
    }
}
