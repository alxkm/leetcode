package com.leetcode.medium.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1743_Restore_the_Array_From_Adjacent_Pairs {
    //1743. Restore the Array From Adjacent Pairs
    //https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (var a: adjacentPairs) {
            int x = a[0];
            int y = a[1];

            if (graph.get(x) == null) graph.put(x, new ArrayList<>());
            if (graph.get(y) == null) graph.put(y, new ArrayList<>());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        int start = -1;
        for (var e: graph.entrySet()) {
            if (e.getValue().size() == 1) {
                start = e.getKey();
                break;
            }
        }
        int[] ar = new int[graph.size()];
        dfs(graph, start, Integer.MAX_VALUE, ar, 0);
        return ar;
    }

    private void dfs(Map<Integer, List<Integer>> graph, int curNode, int from, int[] ar, int i) {
        ar[i] = curNode;
        for (int node: graph.get(curNode)) {
            if (node != from) {
                dfs(graph, node, curNode, ar, i + 1);
            }
        }
    }
}
