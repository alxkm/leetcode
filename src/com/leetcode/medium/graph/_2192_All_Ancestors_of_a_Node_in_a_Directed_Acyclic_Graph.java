package com.leetcode.medium.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class _2192_All_Ancestors_of_a_Node_in_a_Directed_Acyclic_Graph {
    //2192. All Ancestors of a Node in a Directed Acyclic Graph
    //https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/
    //FOREIGN_SOLUTION

    class Solution {
        List<Integer>[] to;

        public List<List<Integer>> getAncestors(int n, int[][] edges) {
            //List<Integer>[] to = new List[n];
            to = new List[n];
            boolean[] used = new boolean[n];

            for (int i = 0; i < n; i++) {
                to[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                to[edge[0]].add(edge[1]);
                used[edge[1]] = true;
            }

            for (int i = 0; i < used.length; i++) {
                if (!used[i]) {
                    Collection<Integer> list = new ArrayList<>();
                    dfs(i, list, new boolean[n]);
                    System.out.println(list);
                }
            }

            return new ArrayList<>();
        }

        private void dfs(int from, Collection<Integer> list, boolean[] used) {
            used[from] = true;
            for (int v : to[from]) {
                if (!used[v]) {
                    dfs(v, list, used);
                }
            }
            list.add(from);
        }

        public static void main(String[] args) {
            int[][] ar = {{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}};

            var sol = new _2192_All_Ancestors_of_a_Node_in_a_Directed_Acyclic_Graph();
            System.out.println(sol.getAncestors(8, ar));
        }
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] gr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            gr[i] = new ArrayList<>();
        }
        boolean[] isInPath = new boolean[n];
        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            gr[a].add(b);
            isInPath[b] = true;
        }

        List<List<Integer>> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) temp.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            if (!isInPath[i] && !gr[i].isEmpty()) {
                Stack<Integer> st = new Stack<>();
                st.add(i);
                for (var v: gr[i]) {
                    dfs(v, gr, st, temp);
                }
            }
        }

        List<List<Integer>> ll = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> l = new ArrayList<>(temp.get(i));
            Collections.sort(l);
            ll.add(l);
        }

        return ll;
    }

    private void dfs(int vertex, List<Integer>[] gr, Stack<Integer> visitedVertexes, List<List<Integer>> temp) {
        temp.get(vertex).addAll(visitedVertexes);
        if (gr[vertex].isEmpty()) {
            return;
        }

        visitedVertexes.push(vertex);
        for (var v: gr[vertex]) {
            dfs(v, gr, visitedVertexes, temp);
        }
        visitedVertexes.pop();
    }

    public static void main(String[] args) {
        int[][] ar = {{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}};
        int[][] ar1 = {{7,5},{2,5},{0,7},{0,1},{6,1},{2,4},{3,5}};

        var sol = new _2192_All_Ancestors_of_a_Node_in_a_Directed_Acyclic_Graph();
        //System.out.println(sol.getAncestors(8, ar));
        System.out.println(sol.getAncestors(9, ar1));
    }
}
/*
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _2192_All_Ancestors_of_a_Node_in_a_Directed_Acyclic_Graph {
    //2192. All Ancestors of a Node in a Directed Acyclic Graph
    //https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph
    //FOREIGN_SOLUTION

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            adjacencyList[to].add(from);
        }

        List<List<Integer>> ancestorsList = new ArrayList<>();

        // For each node, find all its ancestors (children in reversed graph)
        for (int i = 0; i < n; i++) {
            List<Integer> ancestors = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            dfs(i, adjacencyList, visited);
            // Add visited nodes to the current nodes' ancestor list
            for (int node = 0; node < n; node++) {
                if (node == i) continue;
                if (visited.contains(node)) ancestors.add(node);
            }
            ancestorsList.add(ancestors);
        }

        return ancestorsList;
    }

    private void dfs(int currentNode, List<Integer>[] adjacencyList, Set<Integer> visitedNodes) {
        // Mark current node as visited
        visitedNodes.add(currentNode);

        // Recursively traverse all neighbors
        for (int neighbour : adjacencyList[currentNode]) {
            if (!visitedNodes.contains(neighbour)) {
                dfs(neighbour, adjacencyList, visitedNodes);
            }
        }
    }
}
*/
