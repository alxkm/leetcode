package com.leetcode.hard;

import com.leetcode.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _834_Sum_of_Distances_in_Tree {
    //https://leetcode.com/problems/sum-of-distances-in-tree/description/
    //834. Sum of Distances in Tree

    List<Integer>[] gr;
    int[] counter;
    int[] answer;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        gr = new List[n];
        counter = new int[n];
        answer = new int[n];
        for (int i = 0; i < n; i++) gr[i] = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            gr[u].add(v);
            gr[v].add(u);
        }

        dfs1(0, -1);
        dfs2(0, -1);
        return answer;
    }

    private void dfs1(int node, int parent) {
        counter[node] = 1;
        for (int child : gr[node]) {
            if (child == parent) continue;
            dfs1(child, node);
            counter[node] += counter[child];
            answer[node] += answer[child] + counter[child];
        }
    }

    private void dfs2(int node, int parent) {
        counter[node] = 1;
        for (int child : gr[node]) {
            if (child == parent) continue;
            answer[child] = answer[node] - counter[child] + counter.length - counter[child];
            dfs2(child, node);
        }
    }

    public static void main(String[] args) {
        var sol = new _834_Sum_of_Distances_in_Tree();
        int[][] ar = {
                {0, 1},
                {0, 2},
                {2, 3},
                {2, 4},
                {2, 5}
        };
        //System.out.println(Arrays.toString(sol.sumOfDistancesInTree(6, ar2)));
        int[][] ar1 = {
                {2, 0}, {1, 0}
        };
        int[][] ar2 = {
                {2, 1}, {0, 2}
        };
        System.out.println(Arrays.toString(sol.sumOfDistancesInTree(3, ar2)));
    }
}
