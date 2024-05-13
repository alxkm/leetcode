package com.leetcode.medium.matrix;

public class _861_Score_After_Flipping_Matrix {
    //861. Score After Flipping Matrix
    //https://leetcode.com/problems/score-after-flipping-matrix/description/

    public int matrixScore(int[][] grid) {
        for (int[] ints : grid) {
            if (ints[0] == 0) {
                for (int i = 0; i < ints.length; i++) {
                    if (ints[i] == 0) {
                        ints[i] = 1;
                    } else {
                        ints[i] = 0;
                    }
                }
            }
        }

        for (int j = 1; j < grid[0].length; j++) {
            int count = 0;
            for (int[] ints : grid) {
                if (ints[j] == 1) {
                    count++;
                }
            }

            if (grid.length - count > count) {
                for (int i = 0; i < grid.length; i++) {
                    if (grid[i][j] == 1) {
                        grid[i][j] = 0;
                    } else {
                        grid[i][j] = 1;
                    }
                }
            }
        }
        int globalSum = 0;
        for (int[] ints : grid) {
            int bin = 1;
            int sum = 0;
            for (int i = ints.length - 1; i >= 0; i--) {
                sum += ints[i] * bin;
                bin *= 2;
            }
            globalSum += sum;
        }
        return globalSum;
    }
}
