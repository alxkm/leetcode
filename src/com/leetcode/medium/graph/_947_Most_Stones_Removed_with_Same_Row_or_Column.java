package com.leetcode.medium.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _947_Most_Stones_Removed_with_Same_Row_or_Column {
    //947. Most Stones Removed with Same Row or Column
    //https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/

    public int removeStones(int[][] stones) {
        Map<String, Set<String>> map = new HashMap<>();
        for (int[] ar : stones) {
            int x = ar[0];
            int y = ar[1];
            String key = x + "," + y;
            for (int[] row : stones) {
                if (row[0] == x || row[1] == y) {
                    String key1 = row[0] + "," + row[1];
                    map.computeIfAbsent(key, k -> new HashSet<>()).add(key1);
                    map.computeIfAbsent(key1, k -> new HashSet<>()).add(key);
                }
            }
        }
        int componentCount = 0;
        Set<String> visited = new HashSet<>();
        for (String key : map.keySet()) {
            if (!visited.contains(key)) {
                dfs(key, visited, map);
                componentCount++;
            }
        }
        return stones.length - componentCount;
    }

    void dfs(String stone, Set<String> visit, Map<String, Set<String>> map) {
        if (visit.contains(stone)) return;
        visit.add(stone);
        for (String key : map.get(stone)) {
            dfs(key, visit, map);
        }
    }
}
