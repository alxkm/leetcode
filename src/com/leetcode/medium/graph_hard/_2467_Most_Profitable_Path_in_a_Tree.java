package com.leetcode.medium.graph_hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _2467_Most_Profitable_Path_in_a_Tree {
    //https://leetcode.com/problems/most-profitable-path-in-a-tree/description/
    //2467. Most Profitable Path in a Tree

    List<Integer>[] gr;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        dfs(bob, 0);
        Arrays.fill(visited, false);

        Queue<int[]> nodeQueue = new LinkedList<>();
        nodeQueue.add(new int[]{0, 0, 0});
        int maxIncome = Integer.MIN_VALUE;

        while (!nodeQueue.isEmpty()) {
            int[] node = nodeQueue.poll();
            int sourceNode = node[0], time = node[1], income = node[2];

            // Alice reaches the node first
            if (
                    !bobPath.containsKey(sourceNode) ||
                            time < bobPath.get(sourceNode)
            ) {
                income += amount[sourceNode];
            }
            // Alice and Bob reach the node at the same time
            else if (time == bobPath.get(sourceNode)) {
                income += amount[sourceNode] / 2;
            }

            // Update max value if current node is a new leaf
            if (tree.get(sourceNode).size() == 1 && sourceNode != 0) {
                maxIncome = Math.max(maxIncome, income);
            }
            // Explore adjacent unvisited vertices
            for (int adjacentNode : tree.get(sourceNode)) {
                if (!visited[adjacentNode]) {
                    nodeQueue.add(new int[] { adjacentNode, time + 1, income });
                }
            }

            // Mark and remove current node
            visited[sourceNode] = true;
        }

        return maxIncome;
    }

    private Map<Integer, Integer> bobPath = new HashMap<>();
    private boolean[] visited;
    private List<List<Integer>> tree = new ArrayList<>();

    private boolean dfs(int sourceNode, int time) {
        bobPath.put(sourceNode, time);
        visited[sourceNode] = true;

        if (sourceNode == 0) {
            return true;
        }

        for (int adjacentNode : tree.get(sourceNode)) {
            if (!visited[adjacentNode]) {
                if (dfs(adjacentNode, time + 1)) {
                    return true;
                }
            }
        }

        bobPath.remove(sourceNode);
        return false;
    }
}
