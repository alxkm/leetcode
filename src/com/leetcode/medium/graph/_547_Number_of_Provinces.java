package com.leetcode.medium.graph;

public class _547_Number_of_Provinces {
    //https://leetcode.com/problems/number-of-provinces/
    //547. Number of Provinces
    //dfs
    //top

    private boolean[] visit;
    private int m = 0;
    private int n = 0;

    public int findCircleNum(int[][] isConnected) {
        visit = new boolean[isConnected.length];
        int countriesCounter = 0;
        m = isConnected.length;
        n = isConnected[0].length;

        for (int i = 0; i < m; i++) {
            if (!visit[i]) {
                countriesCounter++;
                dfs(isConnected, i);
            }
        }
        return countriesCounter;
    }

    private void dfs(int[][] isConnected, int i) {
        if (i < 0 || i >= m || visit[i]) {
            return;
        }
        visit[i] = true;
        for (int j = 0; j < n; j++) {
            if (isConnected[i][j] == 1 && !visit[j]) {
                dfs(isConnected, j);
            }
        }
    }
}
