package com.leetcode.medium.matrix;

public class _1605_Find_Valid_Matrix_Given_Row_and_Column_Sums {
    //1605. Find Valid Matrix Given Row and Column Sums
    //https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/description/

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;

        int[][] mat = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            mat[r][0] = rowSum[r];
        }

        for (int c = 0; c < cols; c++) {
            long curColSum = 0;
            for (int r = 0; r < rows; r++) {
                curColSum += mat[r][c];
            }

            int r = 0;
            while (curColSum > colSum[c]) { //r > rows && no a case
                long diff = curColSum - colSum[c];
                long maxShift = Math.min(mat[r][c], diff);
                mat[r][c] -= maxShift;
                mat[r][c + 1] += maxShift;

                curColSum -= maxShift;
                r += 1;
            }
        }

        return mat;
    }
}
