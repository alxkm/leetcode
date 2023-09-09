package com.leetcode.medium.matrix;

import java.util.Arrays;

public class _59_Spiral_Matrix_II {
    //https://leetcode.com/problems/spiral-matrix-ii/
    //TOP

    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        int ids = 1, ide = n, ius = n - 1, iue = 0;
        int jrs = 0, jre = n, jls = n - 1, jle = 0;
        char direction = 'r';
        for (int k = 1, i = 0, j = 0; k <= n * n; ) {
            if (direction == 'r') {
                j = jrs;
                while (j < jre) {
                    m[i][j] = k++;
                    j++;
                }
                jre--;
                jrs++;
                j--;
                direction = 'd';
            } else if (direction == 'd') {
                i = ids;
                while (i < ide) {
                    m[i][j] = k++;
                    i++;
                }
                ide--;
                i--;
                ids++;
                direction = 'l';
                jls--;
            } else if (direction == 'l') {
                j = jls;
                while (j >= jle) {
                    m[i][j] = k++;
                    j--;
                }
                j++;
                jle++;
                ius--;
                direction = 'u';
            } else if (direction == 'u') {
                i = ius;
                while (i > iue) {
                    m[i][j] = k++;
                    i--;
                }
                i++;
                iue++;
                //ius--;
                direction = 'r';
            }
        }
        return m;
    }

    public static void main(String[] args) {
        var solution = new _59_Spiral_Matrix_II();
        System.out.println(Arrays.deepToString(solution.generateMatrix(5)));
    }
}
