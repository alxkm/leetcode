package com.leetcode.medium.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _1334_Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance {
    //1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
    //https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/?envType=daily-question&envId=2024-07-26

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<int[]>[] gr = new ArrayList[n];
        for (int i = 0; i < n; i++) gr[i] = new ArrayList<>();
        for (int[] ar: edges) {
            gr[ar[0]].add(new int[]{ar[1], ar[2]});
            gr[ar[1]].add(new int[]{ar[0], ar[2]});
        }
        int[][] distances = new int[n][n];
        for (int i = 0; i < n; i++) distances[i] = dijkstra(gr, i, n);

        int prev = -1;
        int prevCounter = -1;
        for (int i = 0; i < distances.length; i++) {
            int counter = 0;
            for (int d: distances[i]) {
                if (d <= distanceThreshold) {
                    counter++;
                }
            }
            if (prevCounter == -1 || prevCounter >= counter) {
                prev = i;
                prevCounter = counter;
            }
        }
        return prev;
    }

    public int[] dijkstra(List<int[]>[] gr, int source, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        int[] dist = new int[n];
        boolean[] visit = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        pq.add(new int[] {source, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            visit[cur[0]] = true;
            for (int[] v: gr[cur[0]]) {
                if (!visit[v[0]]) pq.add(new int[] {v[0], v[1] + cur[1]});
                int d = v[1] + cur[1];
                if (dist[v[0]] > d) {
                    dist[v[0]] = d;
                }
            }
        }
        return dist;
    }
}
