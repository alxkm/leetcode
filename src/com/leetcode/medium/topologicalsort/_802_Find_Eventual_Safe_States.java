package com.leetcode.medium.topologicalsort;

import java.util.ArrayList;
import java.util.List;

public class _802_Find_Eventual_Safe_States {
    //https://leetcode.com/problems/find-eventual-safe-states/description/
    //802. Find Eventual Safe States

    int[][] graph;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        this.graph = graph;
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(i, color)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean dfs(int node, int[] color) {
        if (color[node] > 0) {
            return color[node] == 2;
        }

        color[node] = 1;
        for (int neighbor : graph[node]) {
            if (!dfs(neighbor, color)) {
                return false;
            }
        }

        color[node] = 2;
        return true;
    }
}
