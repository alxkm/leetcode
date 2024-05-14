package com.leetcode.medium.graph;

import com.leetcode.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _851_Loud_and_Rich {
    //https://leetcode.com/problems/loud-and-rich/description/
    //851. Loud and Rich
    //topsort

//    //851. Loud and Rich
//    //https://leetcode.com/problems/loud-and-rich/
//    Map<Integer, List<Integer>> map = new HashMap<>();
//
//    public int[] loudAndRich(int[][] richer, int[] quiet) {
//        boolean[] greaterThan = new int[];
//        for (int[] rc : richer) {
//            greaterMap.computeIfAbsent(rc[0], k -> new ArrayList<>()).add(rc[0]);
//            map.computeIfAbsent(rc[1], k -> new ArrayList<>()).add(rc[0]);
//        }
//
//        for (int i = 0; i < quiet.length; i++) {
//            dfs(i, i);
//        }
//        int[] ans = new int[quiet.length];
//        for (int i = 0; i < ans.length; i++) {
//            int min = i;
//            for (int i1 : map.get(i)) {
//                min = Math.min(quiet[min], quiet[i1]);
//            }
//            ans[i] = min;
//        }
//        return ans;
//    }
//
//    private void dfs(int v, boolean[] visit, List<Integer> l) {
//        if (visit[v]) return;
//        visit[v] = true;
//
//        for (int v1: map.get(v)) {
//            map.get(v1).add(v);
//            dfs(v1, visit, l);
//        }
//        l.add(v);
//    }
//
//    public static void main(String[] args) {
//        var sol = new _851_Loud_and_Rich();
//        int[][] ints = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
//        int[] of = ArrayUtil.of(3, 2, 5, 4, 6, 1, 7, 0);
//        System.out.println(Arrays.toString(sol.loudAndRich(ints, of)));
//    }

    ArrayList<Integer>[] graph;
    int[] quiet;
    int[] answer;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        this.quiet = quiet;
        int n = quiet.length;
        answer = new int[n];
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<Integer>();
        for (int[] r: richer) graph[r[1]].add(r[0]);
        Arrays.fill(answer, -1);

        for (int i = 0; i < n; i++) {
            if (answer[i] == -1) dfs(i);
        }
        return answer;
    }

    public int dfs(int node) {
        if (answer[node] == -1) {
            answer[node] = node;
            for (int child: graph[node]) {
                int cand = dfs(child);
                if (quiet[cand] < quiet[answer[node]])
                    answer[node] = cand;
            }
        }
        return answer[node];
    }
}
