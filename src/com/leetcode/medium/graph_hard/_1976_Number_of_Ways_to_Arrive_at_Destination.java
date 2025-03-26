package com.leetcode.medium.graph_hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _1976_Number_of_Ways_to_Arrive_at_Destination {
    //1976. Number of Ways to Arrive at Destination
    //https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/

    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;

        // Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int startNode = road[0], endNode = road[1], travelTime = road[2];
            graph.get(startNode).add(new int[] { endNode, travelTime });
            graph.get(endNode).add(new int[] { startNode, travelTime });
        }

        // Min-Heap (priority queue) for Dijkstra
        PriorityQueue<long[]> minHeap = new PriorityQueue<>(
                Comparator.comparingLong(a -> a[0])
        );

        // Store shortest time to each node
        long[] shortestTime = new long[n];
        Arrays.fill(shortestTime, Long.MAX_VALUE);
        // Number of ways to reach each node in shortest time
        int[] pathCount = new int[n];

        shortestTime[0] = 0; // Distance to source is 0
        pathCount[0] = 1; // 1 way to reach node 0

        minHeap.offer(new long[] { 0, 0 }); // {time, node}

        while (!minHeap.isEmpty()) {
            long[] top = minHeap.poll();
            long currTime = top[0]; // Current shortest time
            int currNode = (int) top[1];

            // Skip outdated distances
            if (currTime > shortestTime[currNode]) {
                continue;
            }

            for (int[] neighbor : graph.get(currNode)) {
                int neighborNode = neighbor[0], roadTime = neighbor[1];

                // Found a new shortest path → Update shortest time and reset path count
                if (currTime + roadTime < shortestTime[neighborNode]) {
                    shortestTime[neighborNode] = currTime + roadTime;
                    pathCount[neighborNode] = pathCount[currNode];
                    minHeap.offer(
                            new long[] { shortestTime[neighborNode], neighborNode }
                    );
                }
                // Found another way with the same shortest time → Add to path count
                else if (currTime + roadTime == shortestTime[neighborNode]) {
                    pathCount[neighborNode] =
                            (pathCount[neighborNode] + pathCount[currNode]) % MOD;
                }
            }
        }

        return pathCount[n - 1];
    }
}
