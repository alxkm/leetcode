package com.leetcode.easy.simulation;

public class _1252_Cells_with_Odd_Values_in_a_Matrix {
    static public int oddCells(int m, int n, int[][] indices) {
        int[][] mat = new int[m][n];

        for (var a : indices) {
            for (int i = 0; i < n; i++) {
                mat[a[0]][i]++;
            }
            for (int i = 0; i < m; i++) {
                mat[i][a[1]]++;
            }
        }
        int counter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] % 2 != 0) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int[][] mat = {{0, 1}, {1, 1}};

        System.out.println(oddCells(m, n, mat));
    }
}
