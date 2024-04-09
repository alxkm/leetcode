package com.leetcode.top.bfs;

import java.util.Arrays;

public class _542_01_Matrix {
    //https://leetcode.com/problems/01-matrix/
    //542. 01 Matrix
    //FOREIGN_SOLUTION
    //TOP
    //multidirectional bfs

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        if (mat[0][0] != 0) mat[0][0] = m + n;
        //Travel top down
        for (int j = 1; j < m; j++) {
            if (mat[0][j] != 0) mat[0][j] = mat[0][j - 1] + 1;
        }
        for (int i = 1; i < n; i++) {
            if (mat[i][0] != 0) mat[i][0] = mat[i - 1][0] + 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] != 0) mat[i][j] = Math.min(mat[i - 1][j], mat[i][j - 1]) + 1;
            }
        }
        //Travel up
        for (int j = m - 2; j >= 0; j--) {
            if (mat[n - 1][j] != 0) mat[n - 1][j] = Math.min(mat[n - 1][j], mat[n - 1][j + 1] + 1);
        }
        for (int i = n - 2; i >= 0; i--) {
            if (mat[i][m - 1] != 0) mat[i][m - 1] = Math.min(mat[i][m - 1], mat[i + 1][m - 1] + 1);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                if (mat[i][j] != 0) mat[i][j] = Math.min(mat[i][j], Math.min(mat[i + 1][j], mat[i][j + 1]) + 1);
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        var solution = new _542_01_Matrix();

        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};

        System.out.println(Arrays.deepToString(solution.updateMatrix(mat)));
    }
}
