package com.leetcode.hard;

public class _980_Unique_Paths_III {
    //980. Unique Paths III
    //https://leetcode.com/problems/unique-paths-iii/description/

    public int uniquePathsIII(int[][] grid) {
        int x = 0, y = 0, empty = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                } else if (grid[i][j] == 0) empty++;
            }
        }
        return dfs(x, y, grid, empty);
    }

    private int dfs(int i, int j, int[][] grid, int empty) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1 || empty < 0) return 0;

        if (grid[i][j] == 2) return empty == 0 ? 1 : 0;

        grid[i][j] = -1;
        empty--;
        int ways = dfs(i + 1, j, grid, empty)
                + dfs(i - 1, j, grid, empty)
                + dfs(i, j + 1, grid, empty)
                + dfs(i, j - 1, grid, empty);

        grid[i][j] = 0;
        return ways;
    }
}
