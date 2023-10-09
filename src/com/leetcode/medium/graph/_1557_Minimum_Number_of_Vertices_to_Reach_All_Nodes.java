package com.leetcode.medium.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1557_Minimum_Number_of_Vertices_to_Reach_All_Nodes {
    //https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
    //1557. Minimum Number of Vertices to Reach All Nodes

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        for (int i = 0; i < edges.size(); i++) {
            set.remove(edges.get(i).get(1));
        }
        return new ArrayList<>(set);
    }
}
