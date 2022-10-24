package com.company.graph;

import java.util.HashMap;
import java.util.Map;

public class _1791_Find_Center_of_Star_Graph {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                map.put(edges[i][j], map.getOrDefault(edges[i][j],  0) + 1);
            }
        }

        Map.Entry<Integer, Integer> a = map.entrySet()
                                           .stream()
                                           .findFirst()
                                           .get();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > a.getValue()) {
                a = entry;
            }
        }
        return a.getKey();
    }
}
