package com.leetcode.medium.graph;

public class _695_Max_Area_of_Island {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, 0, i, j));
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int accum, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length
                || j >= grid[0].length || grid[i][j] != 1) return accum;

        accum++;
        grid[i][j] = -1;
        accum = Math.max(accum, dfs(grid, accum, i + 1, j));
        accum = Math.max(accum, dfs(grid, accum, i - 1, j));
        accum = Math.max(accum, dfs(grid, accum, i, j + 1));
        accum = Math.max(accum, dfs(grid, accum, i, j - 1));
        return accum;
    }
}
