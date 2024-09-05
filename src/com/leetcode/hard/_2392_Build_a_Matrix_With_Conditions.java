package com.leetcode.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _2392_Build_a_Matrix_With_Conditions {
    //2392. Build a Matrix With Conditions
    //https://leetcode.com/problems/build-a-matrix-with-conditions/description/

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] orderRows = topoSort(rowConditions, k);
        int[] orderColumns = topoSort(colConditions, k);
        if (orderRows.length == 0 || orderColumns.length == 0) return new int[0][0];
        int[][] matrix = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (orderRows[i] == orderColumns[j]) {
                    matrix[i][j] = orderRows[i];
                }
            }
        }
        return matrix;
    }

    private int[] topoSort(int[][] edges, int n) {
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        int[] deg = new int[n + 1], order = new int[n];
        int idx = 0;
        for (int[] x : edges) {
            adj[x[0]].add(x[1]);
            deg[x[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (deg[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int f = q.poll();
            order[idx++] = f;
            n--;
            for (int v : adj[f]) {
                if (--deg[v] == 0) q.offer(v);
            }
        }
        if (n != 0) return new int[0];
        return order;
    }
}
