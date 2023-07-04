package com.leetcode.medium.graph;

public class _1020_Number_of_Enclaves {
    //https://leetcode.com/problems/number-of-enclaves/

    private int m = 0;
    private int n = 0;

    public int numEnclaves(int[][] grid) {
        int answer = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (((i == 0 || j == 0) || (j == n - 1) || (i == m - 1)) && grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private void dfs(int[][] grid, int i, int j) {
        if ((i < 0 || j < 0) || (i >= m || j >= n) || grid[i][j] == 0) return;
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
