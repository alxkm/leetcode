package com.company.matrix;

import java.util.Arrays;

public class _2022_Convert_1D_Array_Into_2D_Array {
    public static int[][] construct2DArray(int[] original, int m, int n) {
        int[][] a = new int[m][n];
        int[][] a1 = new int[1][1];
        if (n == 1 && m == 1) return a1;
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = original[k++];
            }
        }


        for (int i = 0, j = 0; i < original.length; i++) {
            a[k][j] = original[i];
            if ((i + 1) % m == 0) {
                k++;
                j = 0;
            } else {
                j++;
            }
        }
        return a;
    }

    public int[][] construct2DArray1(int[] original, int m, int n) {
        if (original.length != m*n) return new int[0][0];
        int[][] a = new int[m][n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = original[k++];
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};

        System.out.println(Arrays.deepToString(construct2DArray(a, 1, 3)));
    }
}
