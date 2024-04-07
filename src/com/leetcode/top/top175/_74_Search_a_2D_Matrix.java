package com.leetcode.top.top175;

public class _74_Search_a_2D_Matrix {
    //https://leetcode.com/problems/search-a-2d-matrix/
    //74. Search a 2D Matrix

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row: matrix) {
            if (row[0] <= target && row[row.length - 1] >= target) {
                int l = 0;
                int r = row.length - 1;
                if (row[l] == target || row[r] == target) return true;

                while (l + 1 < r) {
                    int m = (l + r) / 2;
                    if (row[m] == target) return true;

                    if (row[m] < target) {
                        l = m;
                    } else {
                        r = m;
                    }
                }
                if (row[l] == target) return true;
            }
        }
        return false;
    }
}
