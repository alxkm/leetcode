package com.leetcode.easy.slidingwindow;

public class _1314_Matrix_Block_Sum {
    //https://leetcode.com/problems/matrix-block-sum/description/
    //1314. Matrix Block Sum

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] a = new int[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int sum = 0;

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if ((i - k <= r && r <= i + k) && (j - k <= c && c <= j + k)) {
                            sum += mat[i][j];
                        }
                    }
                }
                a[r][c] = sum;
            }
        }
        return a;
    }
}
