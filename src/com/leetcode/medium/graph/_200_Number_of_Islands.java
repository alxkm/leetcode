package com.leetcode.medium.graph;

public class _200_Number_of_Islands {
    //200. Number of Islands
    //https://leetcode.com/problems/number-of-islands/

    int m;
    int n;
    char[][] grid;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        boolean[][] used = new boolean[m][n];
        int counter = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!used[i][j] && grid[i][j] == '1') {
                    dfs(i, j, used);
                    counter++;
                }
            }
        }
        return counter;
    }

    private void dfs(int i, int j, boolean[][] used) {
        if (i < 0 || j < 0 || i >= m || j >= n || used[i][j] || grid[i][j] == '0') {
            return;
        }
        used[i][j] = true;

        dfs(i + 1, j, used);
        dfs(i, j + 1, used);
        dfs(i, j - 1, used);
        dfs(i - 1, j, used);
    }
}
