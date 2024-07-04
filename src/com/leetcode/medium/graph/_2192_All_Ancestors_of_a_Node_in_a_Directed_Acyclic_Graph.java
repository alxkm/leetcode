package com.leetcode.medium.graph;

import java.util.ArrayList;
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
