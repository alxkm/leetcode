package com.leetcode.medium.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _885_Spiral_Matrix_III {
    //885. Spiral Matrix III
    //https://leetcode.com/problems/spiral-matrix-iii/description/

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        // Store all possible directions in an array.
        int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[][] traversed = new int[rows * cols][2];
        int idx = 0;

        // Initial step size is 1, value of d represents the current direction.
        for (int step = 1, direction = 0; idx < rows * cols;) {
            // direction = 0 -> East, direction = 1 -> South
            // direction = 2 -> West, direction = 3 -> North
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < step; ++j) {
                    // Validate the current position
                    if (
                            rStart >= 0 &&
                                    rStart < rows &&
                                    cStart >= 0 &&
                                    cStart < cols
                    ) {
                        traversed[idx][0] = rStart;
                        traversed[idx][1] = cStart;
                        ++idx;
                    }
                    // Make changes to the current position.
                    rStart += dir[direction][0];
                    cStart += dir[direction][1];
                }

                direction = (direction + 1) % 4;
            }
            ++step;
        }
        return traversed;
    }

    public static void main(String[] args) {
        var sol = new _885_Spiral_Matrix_III();
        int rows = 1, cols = 4, rStart = 0, cStart = 0;
        System.out.println(Arrays.deepToString(sol.spiralMatrixIII(rows, cols, rStart, cStart)));
    }
}

class Solution {
    private int rows;
    private int cols;

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        this.rows = rows;
        this.cols = cols;
        int n = rows * cols;
        int ai = rows;
        int aj = cols;
        int bi = rows;
        int bj = cols;
        int ci = cols;
        int cj = rows;
        int di = cols;
        int dj = rows;
        int i = rStart;
        int j = cStart;

        List<int[]> l = new ArrayList<>();
        l.add(new int[] {rStart, cStart});
        while (l.size() < n) {
            ai -= 1;
            aj -= 1;
            bi -= 1;
            bj += 1;
            ci += 1;
            cj -= 1;
            di += 1;
            dj += 1;

            while (j <= bj)if (check(i, ++j)) l.add(new int[] {i, j});               //A to B

            while (i <= di)if (check(++i, j)) l.add(new int[] {i, j});               //up down

            while (j >= cj)if (check(i, --j)) l.add(new int[] {i, j});               // right to left

            while (i >= ai)if (check(--i, j)) l.add(new int[] {i, j});               //down up
        }

/*      A                         B
          * * * * * * * * * ~ * *
          * * * * * * * * * * * *
          * * * * * * * * * * * *
        C                         D            */

        int[][] ar = new int[rows*cols][2];
        i = 0;
        for (int[] ints : l) {
            ar[i] = ints;
        }
        return ar;
    }

    boolean check(int i, int j) {
        return i >= 0 && j >= 0 && i < rows && j < cols;
    }
}
