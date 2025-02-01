package com.leetcode.unionfind;

import com.leetcode.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _827_Making_A_Large_Island {
    //own
    //827. Making A Large Island
    //https://leetcode.com/problems/making-a-large-island/description/
    //hard

    int[][] grid;
    int[] counter = new int[1];
    Map<Pair<Integer, Integer>, Integer> indexToIdMap = new HashMap<>();
    Map<Integer, Integer> idMap = new HashMap<>();

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        int id = 0;
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int maxSize = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 || visit[i][j]) continue;
                counter[0] = 0;
                id++;
                dfs(i, j, visit, id);
                idMap.put(id, counter[0]);
            }
        }
        int[][] dxdy = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) continue;
                int localMax = 1;
                Set<Integer> ids = new HashSet<>();
                for (int[] d : dxdy) {
                    int x = i + d[0];
                    int y = j + d[1];

                    var curId = indexToIdMap.get(new Pair<>(x, y));
                    if (curId == null) continue;
                    if (ids.contains(curId)) continue;
                    ids.add(curId);

                    localMax += idMap.get(curId);
                }

                maxSize = Math.max(localMax, maxSize);
            }
        }

        for (var area: idMap.values()) {
            maxSize = Math.max(area, maxSize);
        }
        return maxSize;
    }

    void dfs(int i, int j, boolean[][] visit, int id) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visit[i][j]) return;
        visit[i][j] = true;
        counter[0]++;
        indexToIdMap.put(new Pair<>(i, j), id);
        dfs(i + 1, j, visit, id);
        dfs(i, j + 1, visit, id);
        dfs(i - 1, j, visit, id);
        dfs(i, j - 1, visit, id);
    }
}
