package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _310_Minimum_Height_Trees {
    //https://leetcode.com/problems/minimum-height-trees/description/
    //310. Minimum Height Trees

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> gr = new HashMap<>();
        for (int[] ed: edges) {
            gr.computeIfAbsent(ed[0], k -> new ArrayList<>()).add(ed[1]);
            gr.computeIfAbsent(ed[1], k -> new ArrayList<>()).add(ed[0]);
        }
        int[] leftNode = dfs(gr, new int[n], 0, -1, 0);
        int[] leftDistances = new int[n];
        int[] rightNode = dfs(gr, leftDistances, leftNode[1], -1, 0);
        int[] rightDistances = new int[n];
        dfs(gr, rightDistances, rightNode[1], -1, 0);

        int maxDistanceToNode = leftDistances[rightNode[1]];

        if (maxDistanceToNode % 2 == 0) {
            int rootDist = maxDistanceToNode / 2;
            for (int i = 0; i < rightDistances.length; i++) {
                if (rightDistances[rightDistances[i]] == rootDist && leftDistances[rightDistances[i]] == rootDist) {
                    return List.of(i);
                }
            }
        }
        List<Integer> l = new ArrayList<>();
        int rootDist = maxDistanceToNode / 2;
        for (int i = 0; i < rightDistances.length; i++) {
            if ((rightDistances[rightDistances[i]] == rootDist && leftDistances[rightDistances[i]] == rootDist + 1)
                || (rightDistances[rightDistances[i]] == rootDist + 1 && leftDistances[rightDistances[i]] == rootDist)) {

                l.add(i);
            }
        }
        return l;
    }

    private int[] dfs(Map<Integer, List<Integer>> gr, int[] distances, int curNode, int prevNode, int dist) {
        int maxDistanceNodeFromCurNode = -1;
        int maxDistanceFromCurNode = -1;
        distances[curNode] = dist;

        for (int n: gr.get(curNode)) {
            if (n != prevNode) {
                int[] newNode = dfs(gr, distances, n, curNode, dist + 1);
                if (newNode[1] > maxDistanceFromCurNode) {
                    maxDistanceNodeFromCurNode = newNode[0];
                    maxDistanceFromCurNode = newNode[1];
                }
            }
        }
        if (maxDistanceNodeFromCurNode == -1)   return new int[] {maxDistanceNodeFromCurNode, maxDistanceFromCurNode};

        return new int[] {curNode, dist};
    }

    public static void main(String[] args) {
        var sol = new _310_Minimum_Height_Trees();
        System.out.println(sol.findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}));
    }
}
