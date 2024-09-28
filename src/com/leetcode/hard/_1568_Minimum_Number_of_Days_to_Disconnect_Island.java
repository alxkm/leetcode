package com.leetcode.hard;

public class _1568_Minimum_Number_of_Days_to_Disconnect_Island {
    //1568. Minimum Number of Days to Disconnect Island
    //https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/description/

    private int[][] grid;
    private boolean[][] visit;

    public int minDays(int[][] grid) {
        if (countIslands(grid) != 1) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (countIslands(grid) != 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    private int countIslands(int[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int islandCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    dfs(i, j, grid, visit);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private void dfs(int i, int j, int[][] grid, boolean[][] visit) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visit[i][j] || grid[i][j] == 0) return;
        visit[i][j] = true;
        dfs(i + 1, j, grid, visit);
        dfs(i - 1, j, grid, visit);
        dfs(i, j + 1, grid, visit);
        dfs(i, j - 1, grid, visit);
    }
}
