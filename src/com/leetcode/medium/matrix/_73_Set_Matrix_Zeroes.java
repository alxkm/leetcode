package com.leetcode.medium.matrix;

import java.util.ArrayList;
import java.util.List;

public class _73_Set_Matrix_Zeroes {
    //https://leetcode.com/problems/set-matrix-zeroes/

    public void setZeroes(int[][] matrix) {
        List<Integer> iThList = new ArrayList<>();
        List<Integer> jThList = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    iThList.add(i);
                    jThList.add(j);
                }
            }
        }

        for (int i: iThList) {
            for (int l = 0; l < matrix[0].length; l++) matrix[i][l] = 0;
        }
        for (int j: jThList) {
            for (int l = 0; l < matrix.length; l++) matrix[l][j] = 0;
        }
    }
}
