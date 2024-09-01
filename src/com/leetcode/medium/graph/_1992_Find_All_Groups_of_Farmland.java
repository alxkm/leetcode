package com.leetcode.medium.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class _1992_Find_All_Groups_of_Farmland {
    //1992. Find All Groups of Farmland
    //https://leetcode.com/problems/find-all-groups-of-farmland/description/

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

class _1992_Find_All_Groups_of_Farmland1 {
    //https://leetcode.com/problems/find-all-groups-of-farmland/description/
    //1992. Find All Groups of Farmland

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

    public static void main(String[] args) {
        var sol = new _1992_Find_All_Groups_of_Farmland1();
        System.out.println(Arrays.deepToString(sol.findFarmland(new int[][]{{1,1,1,1,1,1,1,1,1,1,1,1}})));
        System.out.println(Arrays.deepToString(sol.findFarmland(new int[][]{{1, 0, 0}, {0, 1, 1}, {0, 1, 1}})));
    }
}