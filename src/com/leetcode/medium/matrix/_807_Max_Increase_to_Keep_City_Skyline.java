package com.leetcode.medium.matrix;

import java.util.Arrays;

public class _807_Max_Increase_to_Keep_City_Skyline {
    //https://leetcode.com/problems/max-increase-to-keep-city-skyline/description/
    //807. Max Increase to Keep City Skyline

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rows = new int[n];
        int[] cols = new int[n];

        for (int i = 0; i < n; i++) {
            rows[i] = Arrays.stream(grid[i]).max().getAsInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cols[i] = Math.max(grid[j][i], cols[i]);
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.min(rows[i], cols[j]) - grid[i][j];
            }
        }

        return sum;
    }
}
