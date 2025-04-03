package com.leetcode.medium.unionfind;

import java.util.Arrays;

public class _1267_Count_Servers_that_Communicate {
    //1267. Count Servers that Communicate
    //http://leetcode.com/problems/count-servers-that-communicate/description/?envType=daily-question&envId=2025-01-23

    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        System.out.println(Arrays.toString(row));
        System.out.println(Arrays.toString(col));
        int counter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (row[i] > 1 || col[j] > 1)) {
                    counter++;
                }
            }
        }

        return counter;
    }
}
