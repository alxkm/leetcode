package com.leetcode.easy.matrix;

public class _1672_Richest_Customer_Wealth {
    public int maximumWealth(int[][] accounts) {
        int globalMax = 0;
        for (int i = 0; i < accounts.length; i++) {
            int max = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                max += accounts[i][j];
            }
            globalMax = Math.max(max, globalMax);
        }
        return globalMax;
    }
}
