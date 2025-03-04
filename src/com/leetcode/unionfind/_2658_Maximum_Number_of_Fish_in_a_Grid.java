package com.leetcode.unionfind;

public class _2658_Maximum_Number_of_Fish_in_a_Grid {
    //2658. Maximum Number of Fish in a Grid
    //https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/description/

    int[][] grid;
    boolean[][] visit;
    public int findMaxFish(int[][] grid) {
        this.grid = grid;
        int max = 0;
        visit = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0 && !visit[i][j]) {
                    max = Math.max(max, dfs(i, j));
                }
            }
        }
        return max;
    }

    int dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visit[i][j] || grid[i][j] == 0) return 0;
        visit[i][j] = true;
        return grid[i][j] + dfs(i + 1, j) + dfs(i - 1, j) + dfs(i, j + 1) + dfs(i, j - 1);
    }
}
