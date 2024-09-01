package com.leetcode.medium.matrix;

import com.leetcode.ArrayUtil;

public class _840_Magic_Squares_In_Grid {
    //840. Magic Squares In Grid
    //https://leetcode.com/problems/magic-squares-in-grid/description/?envType=daily-question&envId=2024-08-09

    public int numMagicSquaresInside(int[][] grid) {
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] >= 10) continue;
                if (isMagicSquare(i, j, grid)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private boolean isMagicSquare(int i, int j, int[][] grid) {
        int[] ar = new int[10];
        for (int i1 = i; i1 < i + 3 && i1 < grid.length; i1++) {
            for (int j1 = j; j1 < j + 3 && j1 < grid[0].length; j1++) {
                if (grid[i1][j1] >= 10) return false;
                ar[grid[i1][j1]]++;
            }
        }
        for (int k = 1; k < ar.length; k++) {
            if (ar[k] != 1) return false;
        }
        int row1 = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
        int row2 = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2];
        int row3 = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];

        int col1 = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
        int col2 = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1];
        int col3 = grid[i][ + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2];

        int diag1 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
        int diag2 = grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j];

        return (diag1 == diag2) && (row1 == row2 && row2 == row3) && (col1 == col2 && col2 == col3);
    }

    public static void main(String[] args) {
        var sol = new _840_Magic_Squares_In_Grid();

        System.out.println(sol.numMagicSquaresInside(ArrayUtil.to2d("[[4, 3, 8, 4],[9, 5, 1, 9],[2, 7, 6, 2],[4, 3, 8, 1],[1, 6, 7, 5]]")));
    }
}
