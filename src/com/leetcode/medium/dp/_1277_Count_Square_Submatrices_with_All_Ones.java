package com.leetcode.medium.dp;

public class _1277_Count_Square_Submatrices_with_All_Ones {
    //https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
    //1277. Count Square Submatrices with All Ones

    public int countSquares(int[][] matrix) {
        int counter = 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;

                }
                counter += dp[i][j];
            }
        }

        return counter;
    }
}
