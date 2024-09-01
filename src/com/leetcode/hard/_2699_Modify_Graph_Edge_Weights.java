package com.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _2699_Modify_Graph_Edge_Weights {
    //2699. Modify Graph Edge Weights
    //https://leetcode.com/problems/modify-graph-edge-weights/description/
    //FOREIGN_SOLUTION

    List<int[]>[] graph;
    private static final int INF = (int) 2e9;

    public int[][] modifiedGraphEdges(
            int n,
            int[][] edges,
            int source,
            int destination,
            int target
    ) {
        // Step 1: Build the graph, excluding edges with -1 weights
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            if (edge[2] != -1) {
                graph[edge[0]].add(new int[] { edge[1], edge[2] });
                graph[edge[1]].add(new int[] { edge[0], edge[2] });
            }
        }

        // Step 2: Compute the initial shortest distance from source to destination
        int currentShortestDistance = runDijkstra(n, source, destination);
        if (currentShortestDistance < target) {
            return new int[0][0];
        }

        boolean matchesTarget = (currentShortestDistance == target);

        // Step 3: Iterate through each edge to adjust its weight if necessary
        for (int[] edge : edges) {
            if (edge[2] != -1) continue; // Skip edges with already known weights

            // Set edge weight to a large value if current distance matches target, else set
            // to 1
            edge[2] = matchesTarget ? INF : 1;
            graph[edge[0]].add(new int[] { edge[1], edge[2] });
            graph[edge[1]].add(new int[] { edge[0], edge[2] });

            // Step 4: If current shortest distance does not match target
            if (!matchesTarget) {
                // Compute the new shortest distance with the updated edge weight
                int newDistance = runDijkstra(n, source, destination);
                // If the new distance is within the target range, update edge weight to match
                // target
                if (newDistance <= target) {
                    matchesTarget = true;
                    edge[2] += target - newDistance;
                }
            }
        }

        // Return modified edges if the target distance is achieved, otherwise return an
        // empty result
        return matchesTarget ? edges : new int[0][0];
    }

    // Dijkstra's algorithm to find the shortest path distance
    private int runDijkstra(int n, int source, int destination) {
        int[] minDistance = new int[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]
        );

        Arrays.fill(minDistance, INF);
        minDistance[source] = 0;
        minHeap.add(new int[] { source, 0 });

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > minDistance[u]) continue;

            for (int[] neighbor : graph[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];

                if (d + weight < minDistance[v]) {
                    minDistance[v] = d + weight;
                    minHeap.add(new int[] { v, minDistance[v] });
                }
            }
        }

        return minDistance[destination];
    }
}
