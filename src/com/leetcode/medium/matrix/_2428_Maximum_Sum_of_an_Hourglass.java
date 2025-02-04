package com.leetcode.medium.matrix;

public class _2428_Maximum_Sum_of_an_Hourglass {
    //2428. Maximum Sum of an Hourglass
    //https://leetcode.com/problems/maximum-sum-of-an-hourglass/description/

    public int maxSum(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, getSum(grid, i, j));
            }
        }
        return max;
    }

    int getSum(int[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;
        int sum = grid[r][c];
        if (c + 1 < cols) {
            sum += grid[r][c + 1];
        } else {
            return 0;
        }
        if (c + 2 < cols) {
            sum += grid[r][c + 2];
        } else {
            return 0;
        }

        if (r + 1 < rows && c + 1 < cols) {
            sum += grid[r + 1][c + 1];
        } else {
            return 0;
        }

        if (r + 2 < rows) {
            sum += grid[r + 2][c];
        } else {
            return 0;
        }

        if (r + 2 < rows && c + 1 < cols) {
            sum += grid[r + 2][c + 1];
        } else {
            return 0;
        }
        if (r + 2 < rows && c + 2 < cols) {
            sum += grid[r + 2][c + 2];
        } else {
            return 0;
        }
        return sum;
    }
}
