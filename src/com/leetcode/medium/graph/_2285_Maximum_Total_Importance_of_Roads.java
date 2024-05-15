package com.leetcode.medium.graph;

import java.util.Arrays;

public class _2285_Maximum_Total_Importance_of_Roads {
    //2285. Maximum Total Importance of Roads
    //https://leetcode.com/problems/maximum-total-importance-of-roads/description/

    public long maximumImportance(int n, int[][] roads) {
        int[][] connections = new int[n][2];
        for (int i = 0; i < connections.length; i++) {
            connections[i][0] = i;
        }
        for (int[] a: roads) {
            connections[a[0]][1]++;
            connections[a[1]][1]++;
        }

        Arrays.sort(connections, (x, y) -> x[1] - y[1]);
        int[] backDirection = new int[n];
        for (int i = 0; i < connections.length; i++) {
            backDirection[connections[i][0]] = i + 1;
        }
        long sum = 0l;

        for (int[] a: roads) {
            sum += backDirection[a[0]];
            sum += backDirection[a[1]];
        }
        return sum;
    }
}
