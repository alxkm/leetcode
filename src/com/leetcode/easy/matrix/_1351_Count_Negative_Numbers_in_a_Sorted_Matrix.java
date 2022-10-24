package com.leetcode.easy.matrix;

public class _1351_Count_Negative_Numbers_in_a_Sorted_Matrix {
    public int countNegatives(int[][] grid) {
        int counter = 0;

        for (int[] ints : grid) {
            for (int j = ints.length - 1; j >= 0; j--) {
                if (ints[j] < 0) {
                    counter++;
                } else {
                    break;
                }
            }
        }

        return counter;
    }
}
