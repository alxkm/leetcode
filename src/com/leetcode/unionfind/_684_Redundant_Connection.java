package com.leetcode.unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _684_Redundant_Connection {
    //684. Redundant Connection
    //https://leetcode.com/problems/redundant-connection/description/

    int cycleStart = -1;

    // Perform the DFS and store a node in the cycle as cycleStart.
    private void DFS(
            int src,
            boolean[] visited,
            List<Integer>[] adjList,
            int[] parent
    ) {
        visited[src] = true;

        for (int adj : adjList[src]) {
            if (!visited[adj]) {
                parent[adj] = src;
                DFS(adj, visited, adjList, parent);
                // If the node is visited and the parent is different then the
                // node is part of the cycle.
            } else if (adj != parent[src] && cycleStart == -1) {
                cycleStart = adj;
                parent[adj] = src;
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;

        boolean[] visited = new boolean[N];
        int[] parent = new int[N];
        Arrays.fill(parent, -1);

        List<Integer>[] adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adjList[edge[0] - 1].add(edge[1] - 1);
            adjList[edge[1] - 1].add(edge[0] - 1);
        }

        DFS(0, visited, adjList, parent);

        Map<Integer, Integer> cycleNodes = new HashMap<>();
        int node = cycleStart;
        // Start from the cycleStart node and backtrack to get all the nodes in
        // the cycle. Mark them all in the map.
        do {
            cycleNodes.put(node, 1);
            node = parent[node];
        } while (node != cycleStart);

        // If both nodes of the edge were marked as cycle nodes then this edge
        // can be removed.
        for (int i = edges.length - 1; i >= 0; i--) {
            if (
                    cycleNodes.containsKey(edges[i][0] - 1) &&
                            cycleNodes.containsKey(edges[i][1] - 1)
            ) {
                return edges[i];
            }
        }

        return new int[] {}; // This line should theoretically never be reached
    }
}
