package com.leetcode.medium.dp;

public class _62_Unique_Paths {
    static public int uniquePaths(int m, int n) {

        int[][] a = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    a[i][j] = 1;
                } else {
                    a[i][j] += a[i - 1][j];
                    a[i][j] += a[i][j - 1];
                }
            }
        }

        return a[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(uniquePaths(m, n));
    }
}
