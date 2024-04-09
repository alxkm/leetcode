package com.leetcode.top.top175;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _310_Minimum_Height_Trees {
    //https://leetcode.com/problems/minimum-height-trees/
    //310. Minimum Height Trees
    //FOREIGN_SOLUTION FOREIGN_SOLUTION FOREIGN_SOLUTION
    //graph
    //TODO TODO TODO

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> l = new ArrayList<>();
        if (n <= 0) return l;
        if (n == 1) {
            l.add(0);
            return l;
        }
        int[] degree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] edge: edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) q.add(i);
        }

        while (n > 2) {
            int size = q.size();
            n -= size;

            while (size > 0) {
                size--;
                int v = q.poll();
                for (int i: adj.get(v)) {
                    degree[i]--;
                    if (degree[i] == 1) {
                        q.add(i);
                    }
                }
            }
        }
        l.addAll(q);
        return l;
    }
}
