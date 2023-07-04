package com.leetcode.medium.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _797_All_Paths_From_Source_to_Target {
    //https://leetcode.com/problems/all-paths-from-source-to-target/description/

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, int[]> gr = new HashMap<>();
        for (int i = 0; i < graph.length; i++) gr.put(i, graph[i]);
        dfs(gr, 0, graph.length - 1, new ArrayList<>(), result);
        return result;
    }

    private void dfs(Map<Integer, int[]> gr, int k, int end, ArrayList<Integer> lr, List<List<Integer>> glr) {
        if (k == end) {
            lr.add(end);
            glr.add(new ArrayList<>(lr));
            return;
        }
        lr.add(k);
        for (int i: gr.get(k)) {
            dfs(gr, i, end, lr, glr);
            lr.remove(lr.size() - 1);
        }
    }
}
