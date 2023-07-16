package com.leetcode.top;

public class _240_Search_a_2D_Matrix_II {
    //240. Search a 2D Matrix II
    //https://leetcode.com/problems/search-a-2d-matrix-ii/

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 && n == 0) return false;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }
}
