package com.leetcode.medium.matrix;

import java.util.Arrays;

public class _1727_Largest_Submatrix_With_Rearrangements {
    //1727. Largest Submatrix With Rearrangements
    //https://leetcode.com/problems/largest-submatrix-with-rearrangements/

    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prevRow = new int[n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            int[] curRow = Arrays.copyOf(matrix[i], n);
            for (int j = 0; j < n; j++) {
                if (curRow[j] != 0) {
                    curRow[j] += prevRow[j];
                }
            }
            int[] sortedCur = Arrays.copyOf(curRow, n);
            Arrays.sort(sortedCur);
            for (int k = 0; k < n; k++) {
                ans = Math.max(ans, sortedCur[k] * (n - k));
            }
            prevRow = curRow;
        }
        return ans;
    }
}
