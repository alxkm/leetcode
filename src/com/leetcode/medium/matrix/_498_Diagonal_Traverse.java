package com.leetcode.medium.matrix;

public class _498_Diagonal_Traverse {
    //https://leetcode.com/problems/diagonal-traverse/
    //498. Diagonal Traverse

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] arr = new int[m * n];
        int i = 0, j = 0;
        boolean up = true;
        int c = 0;
        while (c < m * n) {
            if (up) {
                while (i >= 0 && j < n) {
                    System.out.println(mat[i][j]);
                    arr[c] = mat[i][j];
                    i--;
                    j++;
                    c++;
                }

                i++;

                up = false;
            } else {
                while (j >= 0 && i < m) {
                    System.out.println(mat[i][j]);
                    arr[c] = mat[i][j];
                    i++;
                    j--;
                    c++;
                }
                //i--;
                j++;
                up = true;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        var solution = new _498_Diagonal_Traverse();

        int[][] a = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };


        solution.findDiagonalOrder(a);
    }
}
