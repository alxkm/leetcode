package com.leetcode.medium.graph;

import com.leetcode.ArrayUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2685_Count_the_Number_of_Complete_Components {
    //2685. Count the Number of Complete Components
    //https://leetcode.com/problems/count-the-number-of-complete-components/description/

    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] gr = new List[n];

        for (int i = 0; i < n; i++) {
            gr[i] = new ArrayList<Integer>();
        }

        for (int[] e: edges) {
            gr[e[0]].add(e[1]);
            gr[e[1]].add(e[0]);
        }

        int count = 0;
        boolean[] used = new boolean[n];
        Map<Integer, List<Integer>> components = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                dfs(gr, i, used, i, components);
            }
        }

        for (var component: components.entrySet()) {
            boolean fullConnection = true;

            for (int v : component.getValue()) {
                if (gr[v].size() != component.getValue().size() - 1) {
                    fullConnection = false;
                    break;
                }
            }

            if (fullConnection) {
                count++;
            }
        }

        return count;
    }

    private void dfs(List<Integer>[] gr, int u, boolean[] used, int componentId, Map<Integer, List<Integer>> components) {
        if (used[u]) {
            return;
        }
        used[u] = true;
        components.computeIfAbsent(componentId, k -> new ArrayList<>()).add(u);

        for (int v: gr[u]) {
            dfs(gr, v, used, componentId, components);
        }
    }

    public static void main(String[] args) {
        var sol = new _2685_Count_the_Number_of_Complete_Components();
        System.out.println(sol.countCompleteComponents(6, ArrayUtil.to2d("[[0,1],[0,2],[1,2],[3,4]]")));
    }
}
