package com.leetcode.medium.graph;

import java.util.ArrayList;

public class _1992_Find_All_Groups_of_Farmland {
    //1992._Find_All_Groups_of_Farmland
    //https://leetcode.com/problems/find-all-groups-of-farmland/

    int m;
    int n;
    int[][] land;

    public int[][] findFarmland(int[][] land) {
        m = land.length;
        n = land[0].length;
        ArrayList<int[]> starts = new ArrayList<>();
        this.land = land;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int[] dxdy = new int[]{i, j, i, j};
                    starts.add(dxdy);
                    dfs(i, j, dxdy);
                }
            }
        }
        int[][] ar = new int[starts.size()][4];
        for (int i = 0; i < starts.size(); i++) {
            ar[i] = starts.get(i);
        }
        return ar;
    }

    private void dfs(int i, int j, int[] dxdy) {
        if (i < 0 || j < 0 || i >= m || j >= n || land[i][j] == -1 || land[i][j] == 0) return;
        land[i][j] = -1;

        if (dxdy[2] < i) dxdy[2] = i;
        if (dxdy[3] < j) dxdy[3] = j;

        dfs(i + 1, j, dxdy);
        dfs(i, j + 1, dxdy);
        dfs(i - 1, j, dxdy);
        dfs(i, j - 1, dxdy);
    }
}
