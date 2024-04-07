package com.leetcode.medium.graph;

public class _1905_Count_Sub_Islands {
    //https://leetcode.com/problems/count-sub-islands/
    //1905. Count Sub Islands

    private int m = 0;
    private int n = 0;
    private boolean isSubIsland = false;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        int counter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    isSubIsland = true;
                    dfs(i, j, grid1, grid2);
                    if (isSubIsland) counter++;
                }
            }
        }
        return counter;
    }

    private void dfs(int i, int j, int[][] grid1, int[][] grid2) {
        if (i >= m || j >= n || i < 0 || j < 0 || grid2[i][j] != 1) return;
        if (grid1[i][j] != 1) isSubIsland = false;
        grid2[i][j] = -1;
        dfs(i + 1, j, grid1, grid2);
        dfs(i - 1, j, grid1, grid2);
        dfs(i, j + 1, grid1, grid2);
        dfs(i, j - 1, grid1, grid2);
    }
}
