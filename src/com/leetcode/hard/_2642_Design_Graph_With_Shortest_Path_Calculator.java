package com.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2642_Design_Graph_With_Shortest_Path_Calculator {
    //2642. Design Graph With Shortest Path Calculator
    //https://leetcode.com/problems/design-graph-with-shortest-path-calculator/

    class Graph {
        class Edge {
            public int to;
            public int weight;

            public Edge(int to, int weight) {
                this.to = to;
                this.weight = weight;
            }
        }

        private final Map<Integer, List<Edge>> graph;
        private final int n;
        private final int INF = Integer.MAX_VALUE;

        public Graph(int n, int[][] edges) {
            this.graph = new HashMap<>();
            this.n = n;
            for (int[] e: edges) {
                int from = e[0];
                int to = e[1];
                int w = e[2];
                if (graph.get(from) == null) {
                    graph.put(from, new ArrayList<>());
                }
                graph.get(from).add(new Edge(to, w));
            }
        }

        public void addEdge(int[] edge) {
            if (graph.get(edge[0]) == null) graph.put(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new Edge(edge[1], edge[2]));
        }

        public int shortestPath(int node1, int node2) {
            long[] dist = new long[n];
            for (int i = 0; i < n; i++) {
                dist[i] = INF;
            }
            dist[node1] = 0;
            boolean[] visit = new boolean[n];
            for (var v: graph.entrySet()) {
                int nearest = -1;

                for (int i = 0; i < n; i++) {
                    if (!visit[i] && (nearest == -1 || dist[nearest] > dist[i]))
                        nearest = i;
                }

                visit[nearest] = true;
                if (graph.get(nearest) == null) continue;

                for (var relax: graph.get(nearest)) {
                    if (dist[relax.to] > dist[nearest] + relax.weight) {
                        dist[relax.to] = dist[nearest] + relax.weight;
                    }
                }
            }

            if (dist[node2] == INF) return -1;

            return (int)dist[node2];
        }
    }

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
}
