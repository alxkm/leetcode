package com.leetcode.hard;

import java.util.Arrays;
import java.util.List;

public class _1463_Cherry_Pickup_II {
    //1463. Cherry Pickup II
    //https://leetcode.com/problems/cherry-pickup-ii/

    int dp[][][];
    int m;
    int n;
    int[][] grid;

    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        dp = new int[m][n][n];
        Arrays.fill(dp, -1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return f(0, n - 1, 0);
    }

    private int f(int c1, int c2, int r) {
        if (c1 == c2 || Math.max(c1, c2) >= n || Math.min(c1, c2) < 0) return 0;
        if (r == m - 1) return grid[r][c1] + grid[r][c2];
        if (dp[r][c1][c2] != -1) return dp[r][c1][c2];

        int[] mx = new int[9];

        mx[0] = f(c1 + 1, c2, r + 1);
        mx[1] = f(c1 + 1, c2 + 1, r + 1);
        mx[2] = f(c1 + 1, c2 - 1, r + 1);
        mx[3] = f(c1 - 1, c2, r + 1);
        mx[4] = f(c1 - 1, c2 + 1, r + 1);
        mx[5] = f(c1 - 1, c2 - 1, r + 1);
        mx[6] = f(c1, c2, r + 1);
        mx[7] = f(c1, c2 + 1, r + 1);
        mx[8] = f(c1, c2 - 1, r + 1);

        int max = mx[0];
        for (int n: mx) max = Math.max(n, max);
        dp[r][c1][c2] = max + grid[r][c1] + grid[r][c2];

        return dp[r][c1][c2];
    }

    public static void main(String[] args) {
        var sol = new _1463_Cherry_Pickup_II();
        int[][] array = {
                {3, 1, 1},
                {2, 5, 1},
                {1, 5, 5},
                {2, 1, 1}
        };

        System.out.println(sol.cherryPickup(array));
    }
}
