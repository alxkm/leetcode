package com.leetcode.easy.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class _1971_Find_if_Path_Exists_in_Graph {
    //1971. Find if Path Exists in Graph
    //https://leetcode.com/problems/find-if-path-exists-in-graph/

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] a : edges) {
            var list = map.getOrDefault(a[0], new ArrayList<>());
            list.add(a[1]);
            map.put(a[0], list);
            list = map.getOrDefault(a[1], new ArrayList<>());
            list.add(a[0]);
            map.put(a[1], list);
        }

        boolean[] v = new boolean[n];
        Stack<Integer> st = new Stack<>();
        st.push(source);
        while (!st.isEmpty()) {
            int vertex = st.pop();
            if (v[vertex]) continue;
            v[vertex] = true;
            for (int i : map.get(vertex)) {
                if (i == destination) return true;
                st.push(i);
            }
        }
        return false;
    }

    //new

    Map<Integer, List<Integer>> map = new HashMap<>();
    public boolean validPath1(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        for (int[] v: edges) {
            map.computeIfAbsent(v[0], s -> new ArrayList<>()).add(v[1]);
            map.computeIfAbsent(v[1], s -> new ArrayList<>()).add(v[0]);
        }

        boolean[] visit = new boolean[n];
        return dfs(source, visit, destination);
    }

    public boolean dfs(int a, boolean[] visit, int destination) {
        if (visit[a]) return false;
        visit[a] = true;
        if (a == destination) return true;
        for (int v: map.get(a)) {
            if(dfs(v, visit, destination)) return true;
        }
        return false;
    }
}
