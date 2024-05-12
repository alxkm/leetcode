package com.leetcode.easy.matrix;

public class _2373_Largest_Local_Values_in_a_Matrix {
    //2373. Largest Local Values in a Matrix
    //https://leetcode.com/problems/largest-local-values-in-a-matrix/

    public int getMax(int[][] grid, int x, int y) {
        int max = 0;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }


    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ar = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                ar[i][j] = getMax(grid, i, j);

            }
        }
        return ar;
    }
}
