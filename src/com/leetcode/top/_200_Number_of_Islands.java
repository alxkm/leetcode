package com.leetcode.top;

public class _200_Number_of_Islands {
    //https://leetcode.com/problems/number-of-islands/
    //FOREIGN_SOLUTION
    //TOP

    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int counter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    counter++;
                }
            }
        }
        return counter;
    }

    private void dfs(char[][] grid, int i, int j) {
        if ((i < 0 || j < 0) || (i >= m || j >= n)) return;
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }
}
