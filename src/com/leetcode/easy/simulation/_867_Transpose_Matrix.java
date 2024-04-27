package com.leetcode.easy.simulation;

import java.util.Arrays;

public class _867_Transpose_Matrix {
    //867. Transpose Matrix
    //https://leetcode.com/problems/transpose-matrix/description/

    static public int[][] transpose(int[][] matrix) {
        int[][] mat = new int[matrix[0].length][matrix.length];

        int i = 0;
        for (int[] ints : matrix) {
            for (int l = 0; l < ints.length; l++) {
                mat[l][i] = ints[l];
            }
            i++;
        }
        return mat;
    }

    public int[][] transpose1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = matrix[j][i];
            }
        }
        return a;
    }

    public static void main(String[] args) {
//        int[][]
//        matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
        int[][] matrix = {
                {1,2,3},
                {4,5,6}
        };
        System.out.println(Arrays.deepToString(transpose(matrix)));
    }
}
