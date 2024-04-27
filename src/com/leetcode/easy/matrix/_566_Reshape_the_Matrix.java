package com.leetcode.easy.matrix;

public class _566_Reshape_the_Matrix {
    //https://leetcode.com/problems/reshape-the-matrix/description/
    //566. Reshape the Matrix

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c) return mat;
        int[][] m = new int[r][c];
        int[] a = new int[mat.length * mat[0].length];

        for (int i = 0, k = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                a[k++] = mat[i][j];
            }
        }
        int[] aa = new int[r];
        for (int i = 0, k = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                m[i][j] = a[k++];
            }
        }
        return m;
    }
}
