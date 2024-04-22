package com.leetcode.easy.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _463_Island_Perimeter {
    //463. Island Perimeter
    //https://leetcode.com/problems/island-perimeter/

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

    public int islandPerimeter2(int[][] grid) {
        boolean[] ar = new boolean[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !ar[i]) {
                    ar[i] = true;
                    //ar
                }
            }    
        }
    return 1;
    }
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            for (int j = 0; j < favoriteCompanies.get(i).size(); j++) {
                map.computeIfAbsent(favoriteCompanies.get(i).get(j), k -> new ArrayList<>()).add(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            boolean needAdditionalCheck = true;
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < favoriteCompanies.get(i).size(); j++) {
                if (map.get(favoriteCompanies.get(i).get(j)).size() == 1) {
                    list.add(i);
                    needAdditionalCheck = false;
                    break;
                } else {
                    for (Integer integer : map.get(favoriteCompanies.get(i).get(j))) {
                        if (integer != i) set.add(integer);
                    }
                }
            }

            if (needAdditionalCheck) {
                boolean includesAll = false;
                for (Integer n : set) {
                    if (favoriteCompanies.get(n).containsAll(favoriteCompanies.get(i))) {
                        includesAll = true;
                        break;
                    }
                }
                if (!includesAll) list.add(i);
            }
        }
        return list;
    }
}
