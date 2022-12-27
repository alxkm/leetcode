package com.leetcode.easy.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _463_Island_Perimeter {
    public int islandPerimeter(int[][] grid) {
        Map<Integer, Set<Integer>> v = new HashMap<>();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return dfs(grid, v, i, j);
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, Map<Integer, Set<Integer>> v, int i, int j) {
        Set<Integer> set = v.getOrDefault(i, new HashSet<>());
        if (set.contains(j)) return 0;

        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 0) {
            System.out.println("i = " + i + " j = " + j);
            return 1;
        }
        set.add(j);
        v.put(i, set);

        int counter = 0;
        counter += dfs(grid, v, i + 1, j);
        counter += dfs(grid, v, i, j + 1);
        counter += dfs(grid, v, i - 1, j);
        counter += dfs(grid, v, i, j - 1);

        return counter;
    }


    public int islandPerimeter1(int[][] grid) {
        int counter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0) {
                        counter++;
                    } else if (grid[i - 1][j] == 0) {
                        counter++;
                    }

                    if (i == grid.length - 1) {
                        counter++;
                    } else if (grid[i + 1][j] == 0) {
                        counter++;
                    }

                    if (j == 0) {
                        counter++;
                    } else if (grid[i][j - 1] == 0) {
                        counter++;
                    }

                    if (j == grid[0].length - 1) {
                        counter++;
                    } else if (grid[i][j + 1] == 0) {
                        counter++;
                    }
                }
            }
        }

        return counter;
    }
}
