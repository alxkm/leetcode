package com.leetcode.easy.matrix;

public class _2923_Find_Champion_I {
    //2923. Find Champion I
    //https://leetcode.com/problems/find-champion-i/description/

    public int findChampion(int[][] grid) {
        for (int j = 0; j < grid[0].length; j++) {
            boolean allZeros = true;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    allZeros = false;
                    break;
                }
            }
            if (allZeros) return j;
        }
        return 0;
    }
}
