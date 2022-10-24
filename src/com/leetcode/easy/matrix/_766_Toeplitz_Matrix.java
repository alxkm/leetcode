package com.leetcode.easy.matrix;

public class _766_Toeplitz_Matrix {

    static public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int e = matrix[i][0];
            for (int j = i + 1, k = 1; j < matrix.length && k < matrix[j].length; j++, k++) {
                if (matrix[j][k] != e) {
                    return false;
                }
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            int e = matrix[0][i];
            for (int j = 1, k = i + 1; j < matrix.length && k < matrix[j].length; j++, k++) {
                if (matrix[j][k] != e) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2},
                {2,1}};
        System.out.println(isToeplitzMatrix(matrix));
    }
}
