package com.leetcode.easy.matrix;

public class _1582_Special_Positions_in_a_Binary_Matrix {
    //1582. Special Positions in a Binary Matrix
    //https://leetcode.com/problems/special-positions-in-a-binary-matrix/description/

    public int numSpecial(int[][] mat) {
        int counter = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0 || mat[i][j] > 1) continue;
                boolean good = true;
                for (int k = 0; k < mat.length && good; k++) {
                    if (k != i && mat[k][j] >= 1) {
                        good = false;
                    };
                }
                for (int k = 0; k < mat[0].length && good; k++) {
                    if (k != j && mat[i][k] >= 1) {
                        good = false;
                    }
                }
                if (good) counter++;
            }
        }
        return counter;
    }
}
