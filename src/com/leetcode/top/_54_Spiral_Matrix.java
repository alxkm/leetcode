package com.leetcode.top;

import java.util.ArrayList;
import java.util.List;

public class _54_Spiral_Matrix {
    //https://leetcode.com/problems/spiral-matrix/
    //FOREIGN_SOLUTION

    public List<Integer> spiralOrder(int[][] matrix) {
        int i = 0, j = 0, im = matrix.length, jm = matrix[0].length;
        List<Integer> l = new ArrayList<>();
        int direction = 0;
        int size = matrix[0].length * matrix.length;
        while (i < im || j < jm) {
            l.addAll(getNextLine(matrix, i, j, im, jm, ++direction));
            //System.out.println(l);
            if (size == l.size()) break;

            if (direction == 4) {
                direction = 0;
                i++;
                j++;
                im--;
                jm--;
            }
        }
        return l;
    }
    public List<Integer> getNextLine(int[][] m, int ii, int jj, int im, int jm, int direction) {
        List<Integer> l = new ArrayList<>();
        if (direction == 1) {
            //move from l to r
            for (int j = jj; j < jm; j++) {
                l.add(m[ii][j]);
            }
        } else if (direction == 2) {
            //from top to bottom
            for (int i = ii + 1; i < im; i++) {
                l.add(m[i][jm - 1]);
            }
        } else if (direction == 3) {
            //from r to l
            for (int j = jm - 2; j >= jj; j--) {
                l.add(m[im - 1][j]);
            }
        } else if (direction == 4) {
            // from bottom to top
            for (int i = im - 2; i > ii; i--) {
                l.add(m[i][jj]);
            }
        }
        return l;
    }
}
