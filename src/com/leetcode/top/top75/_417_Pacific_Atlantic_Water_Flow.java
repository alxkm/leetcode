package com.leetcode.top.top75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _417_Pacific_Atlantic_Water_Flow {
    //https://leetcode.com/problems/pacific-atlantic-water-flow/
    //417. Pacific Atlantic Water Flow
    //FOREIGN_SOLUTION
    //TOP

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        Set<String> pac = new HashSet<>();
        Set<String> atl = new HashSet<>();

        for (int i = 0; i < cols; i++) {
            dfs(pac, heights[0][i], 0, i, heights);
            dfs(atl, heights[rows - 1][i], rows - 1, i, heights);
        }
        for (int i = 0; i < rows; i++) {
            dfs(pac, heights[i][0], i, 0, heights);
            dfs(atl, heights[i][cols - 1], i, cols - 1, heights);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String key = i + "_" + j;
                if (pac.contains(key) && atl.contains(key)) {
                    list.add(List.of(i, j));
                }
            }
        }
        return list;
    }

    private void dfs(Set<String> visit, int h, int i, int j, int[][] heights) {
        if (i < 0 || i >= heights.length
                || j < 0 || j >= heights[0].length
                || heights[i][j] < h) {
            return;
        }
        String key = i + "_" + j;
        if (visit.contains(key)) return;
        visit.add(key);

        dfs(visit, heights[i][j], i + 1, j, heights);
        dfs(visit, heights[i][j], i - 1, j, heights);
        dfs(visit, heights[i][j], i, j + 1, heights);
        dfs(visit, heights[i][j], i, j - 1, heights);
    }

    public static void main(String[] args) {
        _417_Pacific_Atlantic_Water_Flow solution = new _417_Pacific_Atlantic_Water_Flow();
        int[][] ar = {
                {1, 1},
                {1, 1},
                {1, 1}
        };
        solution.pacificAtlantic(ar);
    }
}
