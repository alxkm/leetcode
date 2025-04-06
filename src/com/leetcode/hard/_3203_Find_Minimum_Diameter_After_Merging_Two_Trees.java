package com.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class _3203_Find_Minimum_Diameter_After_Merging_Two_Trees {
    //3203. Find Minimum Diameter After Merging Two Trees
    //https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/description/

    class Solution {

        public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
            // Calculate the number of nodes for each tree (number of edges + 1)
            int n = edges1.length + 1;
            int m = edges2.length + 1;

            // Build adjacency lists for both trees
            List<List<Integer>> adjList1 = buildAdjList(n, edges1);
            List<List<Integer>> adjList2 = buildAdjList(m, edges2);

            // Calculate the diameter of both trees
            int diameter1 = findDiameter(adjList1, 0, -1).getFirst(); // Start DFS for Tree 1
            int diameter2 = findDiameter(adjList2, 0, -1).getFirst(); // Start DFS for Tree 2

            // Calculate the diameter of the combined tree
            int combinedDiameter =
                    (int) Math.ceil(diameter1 / 2.0) +
                            (int) Math.ceil(diameter2 / 2.0) +
                            1;

            // Return the maximum diameter among the two trees and the combined tree
            return Math.max(Math.max(diameter1, diameter2), combinedDiameter);
        }

        // Helper function to build an adjacency list from an edge list
        private List<List<Integer>> buildAdjList(int size, int[][] edges) {
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                adjList.get(edge[0]).add(edge[1]);
                adjList.get(edge[1]).add(edge[0]);
            }
            return adjList;
        }

        // Helper function to find the diameter of a tree
        // Returns the diameter and the depth of the node's subtree
        private Pair findDiameter(
                List<List<Integer>> adjList,
                int node,
                int parent
        ) {
            int maxDepth1 = 0, maxDepth2 = 0; // Tracks the two largest depths from the current node
            int diameter = 0; // Tracks the diameter of the subtree

            for (int neighbor : adjList.get(node)) {
                if (neighbor == parent) continue; // Skip the parent to avoid cycles

                // Recursively calculate the diameter and depth of the neighbor's subtree
                Pair result = findDiameter(adjList, neighbor, node);
                int childDiameter = result.getFirst();
                int depth = result.getSecond() + 1; // Increment depth to include edge to neighbor

                // Update the maximum diameter of the subtree
                diameter = Math.max(diameter, childDiameter);

                // Update the two largest depths from the current node
                if (depth > maxDepth1) {
                    maxDepth2 = maxDepth1;
                    maxDepth1 = depth;
                } else if (depth > maxDepth2) {
                    maxDepth2 = depth;
                }
            }

            // Update the diameter to include the path through the current node
            diameter = Math.max(diameter, maxDepth1 + maxDepth2);

            // Return the diameter and the longest depth
            return new Pair(diameter, maxDepth1);
        }

        // Simple Pair class for storing results of the findDiameter function
        class Pair {

            private int first;
            private int second;

            public Pair(int first, int second) {
                this.first = first;
                this.second = second;
            }

            public int getFirst() {
                return first;
            }

            public int getSecond() {
                return second;
            }
        }
    }
}
