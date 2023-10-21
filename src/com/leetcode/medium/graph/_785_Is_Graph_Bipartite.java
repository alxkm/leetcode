package com.leetcode.medium.graph;

import java.util.Arrays;

public class _785_Is_Graph_Bipartite {
    //https://leetcode.com/problems/is-graph-bipartite/
    //FOREIGN_SOLUTION
    //TOP

    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        Arrays.fill(visited, 0);
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0 && !dfs(graph, visited, 1, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] visited, int color, int v) {
        visited[v] = color;

        for (int to: graph[v]) {
            if (visited[to] == 0) {
                boolean isBiplate = dfs(graph, visited, 3 - color, to);
                if (!isBiplate) return false;
            } else if (visited[to] == color) {
                return false;
            }
        }

        return true;
    }
}
