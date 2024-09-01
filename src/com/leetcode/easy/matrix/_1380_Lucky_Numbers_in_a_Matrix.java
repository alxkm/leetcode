package com.leetcode.easy.matrix;

import java.util.ArrayList;
import java.util.List;

public class _1380_Lucky_Numbers_in_a_Matrix {
    //1380. Lucky Numbers in a Matrix
    //https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/?envType=daily-question&envId=2024-07-19
    //not_optimal

    static public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> mins = new ArrayList<>();
        List<Integer> maxs = new ArrayList<>();
        for (int[] row : matrix) {
            int min = 1000000;
            for (int i : row) {
                min = Math.min(min, i);
            }
            mins.add(min);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            int max = -1;
            for (int j = 0; j < matrix.length; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            maxs.add(max);
        }
        List<Integer> l = new ArrayList<>();
        for (Integer i : mins) {
            if (maxs.contains(i)) {
                l.add(i);
            }
        }
        return l;
    }

    public List<Integer> luckyNumbers1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] mx = new int[n];

        for (int j = 0; j < n; j++) {
            int max = matrix[0][j];
            for (int i = 0; i < m; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            mx[j] = max;
        }

        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int localMin = matrix[i][0];
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < localMin) {
                    localMin = matrix[i][j];
                    index = j;
                }
            }
            if (mx[index] == localMin) {
                l.add(localMin);
            }
        }
        return l;
    }

    public static void main(String[] args) {
        //[[1,10,4,2],[9,3,8,7],[15,16,17,12]]
        int[][] a = {
                {1, 10, 4,  2},
                {9,  3,  8, 7},
                {15, 16,17, 12}
        };

        System.out.println(luckyNumbers(a));
    }
}
