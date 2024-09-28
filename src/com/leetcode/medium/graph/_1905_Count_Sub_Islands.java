package com.leetcode.medium.graph;

import java.util.HashSet;
import java.util.Set;

public class _1905_Count_Sub_Islands {
    //https://leetcode.com/problems/count-sub-islands/description/?envType=daily-question&envId=2024-08-28
    //1905. Count Sub Islands

    private int m = 0;
    private int n = 0;
    private boolean isSubIsland = false;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        int counter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    isSubIsland = true;
                    dfs(i, j, grid1, grid2);
                    if (isSubIsland) counter++;
                }
            }
        }
        return counter;
    }

    private void dfs(int i, int j, int[][] grid1, int[][] grid2) {
        if (i >= m || j >= n || i < 0 || j < 0 || grid2[i][j] != 1) return;
        if (grid1[i][j] != 1) isSubIsland = false;
        grid2[i][j] = -1;
        dfs(i + 1, j, grid1, grid2);
        dfs(i - 1, j, grid1, grid2);
        dfs(i, j + 1, grid1, grid2);
        dfs(i, j - 1, grid1, grid2);
    }

    class Solution {
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            boolean[][] visit1 = new boolean[grid1.length][grid1[0].length];
            boolean[][] visit2 = new boolean[grid1.length][grid1[0].length];

            int counter = 0;
            Set<String> set1 = new HashSet<>();
            for (int i = 0; i < grid1.length; i++) {
                for (int j = 0; j < grid1[0].length; j++) {
                    if (grid1[i][j] == 1 && grid2[i][j] == 1) {
                        if (!visit1[i][j]) {
                            dfs(i, j, grid1, visit1, set1);
                        }
                        if (!visit2[i][j]) {
                            Set<String> set2 = new HashSet<>();
                            dfs(i, j, grid2, visit2, set2);
                            if (set2.size() > set1.size()) continue;
                            boolean containsAll = true;
                            for (String s : set2) {
                                if (!set1.contains(s)) {
                                    containsAll = false;
                                    break;
                                }
                            }
                            if (containsAll) {
                                counter++;
                            }
                        }
                    }
                }
            }
            return counter;
        }

        private void dfs(int i, int j, int[][] grid, boolean[][] visit, Set<String> set) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visit[i][j] || grid[i][j] == 0) return;
            visit[i][j] = true;
            set.add(i + "," + j);
            dfs(i + 1, j, grid, visit, set);
            dfs(i - 1, j, grid, visit, set);
            dfs(i, j + 1, grid, visit, set);
            dfs(i, j - 1, grid, visit, set);
        }
    }
}
