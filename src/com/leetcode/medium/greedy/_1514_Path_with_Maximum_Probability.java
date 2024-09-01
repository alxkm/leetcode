package com.leetcode.medium.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _1514_Path_with_Maximum_Probability {
    //1514. Path with Maximum Probability
    //https://leetcode.com/problems/path-with-maximum-probability/description/?envType=daily-question&envId=2024-08-31

    record Edge(int v, double w) {}

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<Edge>[] gr = new ArrayList[n];
        for (int i = 0; i < n; i++) gr[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            gr[u].add(new Edge(v, succProb[i]));
            gr[v].add(new Edge(u, succProb[i]));
        }
        double[] dist = new double[n];
        dijkstra(gr, start_node, dist);
        return dist[end_node];
    }

    public void dijkstra(List<Edge>[] graph, int start, double[] dist) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> Double.compare(y.w, x.w));
        dist[start] = 1.0;
        pq.add(new Edge(start, 1.0));
        boolean[] visit = new boolean[graph.length];

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visit[cur.v]) continue;
            visit[cur.v] = true;
            int v = cur.v;
            for (var u: graph[v]) {
                double diff =  u.w * dist[v];
                if (dist[u.v] < diff) {
                    dist[u.v] = diff;
                    pq.offer(new Edge(u.v, diff));
                }
            }
        }
    }
}

class Solution {
    record Edge(int v, double w) {}

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(new Edge(v, succProb[i]));
            graph[v].add(new Edge(u, succProb[i]));
        }
        double[] dist = new double[n];
        Arrays.fill(dist, 0.0);  // Start with 0 probability for all nodes.
        dist[start_node] = 1.0;  // Start node has a probability of 1.
        dijkstra(start_node, new boolean[n], dist, graph);
        return dist[end_node];
    }

    private void dijkstra(int start, boolean[] visit, double[] dist, List<Edge>[] graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> Double.compare(y.w, x.w));
        pq.add(new Edge(start, 1.0));

        while (!pq.isEmpty()) {
            Edge vertex = pq.poll();
            if (visit[vertex.v]) continue;
            visit[vertex.v] = true;
            int v = vertex.v;
            for (var edge : graph[v]) {
                double newProb = dist[v] * edge.w;
                if (newProb > dist[edge.v]) {
                    dist[edge.v] = newProb;
                    pq.offer(new Edge(edge.v, newProb));
                }
            }
        }
    }
}
