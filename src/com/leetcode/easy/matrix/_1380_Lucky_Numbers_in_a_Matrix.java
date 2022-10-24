package com.leetcode.easy.matrix;

import java.util.ArrayList;
import java.util.List;

public class _1380_Lucky_Numbers_in_a_Matrix {
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
