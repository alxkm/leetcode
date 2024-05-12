package com.leetcode.medium.matrix;

public class _2482_Difference_Between_Ones_and_Zeros_in_Row_and_Column {
    //2482. Difference Between Ones and Zeros in Row and Column
    //https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/description/

    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 2 * row[i] + 2 * col[j] - m - n;
            }
        }
        return grid;
    }
}
