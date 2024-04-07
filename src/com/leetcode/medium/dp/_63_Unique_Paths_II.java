package com.leetcode.medium.dp;

public class _63_Unique_Paths_II {
    //https://leetcode.com/problems/unique-paths-ii/
    //63. Unique Paths II
    //dp

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        if (obstacleGrid[0][0] == 1 ||
                obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) return 0;
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int[][] og = obstacleGrid;
        int m = og.length, n = og[0].length;
        int[][] dp = new int[m][n];
        if (og == null || og[0][0] == 1 || og[m - 1][n - 1] == 1) return 0;
        dp[0][0] = 1;
        for (int i = 1, j = 1; i < m || j < n; i++, j++) {
            if (i < m) dp[i][0] = (og[i][0] == 1) ? 0 : dp[i - 1][0];
            if (j < n) dp[0][j] = (og[0][j] == 1) ? 0 : dp[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (og[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obs) {
        if (obs[0][0] == 1) return 0;
        int m = obs.length;
        int n = obs[0].length;
        if (obs[m - 1][n - 1] == 1) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) if (obs[i][0] == 1) dp[i][0] = 0; else dp[i][0] = dp[i - 1][0];
        for (int j = 1; j < n; j++) if (obs[0][j] == 1) dp[0][j] = 0; else dp[0][j] = dp[0][j - 1];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obs[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        var sol = new _63_Unique_Paths_II();
        System.out.println(sol.uniquePathsWithObstacles2(a));

    }
}
