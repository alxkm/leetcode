package com.leetcode.hard;

import java.util.Arrays;

public class _1289_Minimum_Falling_Path_Sum_II {
    //1289. Minimum Falling Path Sum II
    //https://leetcode.com/problems/minimum-falling-path-sum-ii/description/
    int[][] grid;
    int m;
    int n;
    int[][] dp;

    public int minFallingPathSum(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n];
        for (int[] ar : dp) Arrays.fill(ar, -1);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, f(0, i));
        }
        return min;
    }

    private int f(int i, int j) {
        if (i == m - 1) return grid[i][j];
        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            if (k != j) {
                min = Math.min(min, f(i + 1, k));
            }
        }
        dp[i][j] = min + grid[i][j];
        return dp[i][j];
    }

    public static void main(String[] args) {
        var sol = new _1289_Minimum_Falling_Path_Sum_II();
        int[][] ar = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] ar1 = {
                {2, 2, 1, 2, 2},
                {2, 2, 1, 2, 2},
                {2, 2, 1, 2, 2},
                {2, 2, 1, 2, 2},
                {2, 2, 1, 2, 2}
        };
        int[][] ar2 = {
                {-73, 61, 43, -48, -36},
                {3, 30, 27, 57, 10},
                {96, -76, 84, 59, -15},
                {5, -49, 76, 31, -7},
                {97, 91, 61, -46, 67}};
        System.out.println(sol.minFallingPathSum(ar1));
    }
    /**
    *
        //ok

        class Solution {
            int[][] grid;
            int m;
            int n;
            Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

            public int minFallingPathSum(int[][] grid) {
                this.grid = grid;
                m = grid.length;
                n = grid[0].length;
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    min = Math.min(min, f(0, i));
                }
                return min;
            }

            private int f(int i, int j) {
                if (i == m - 1) return grid[i][j];

                Pair<Integer, Integer> key = new Pair<>(i, j);
                Integer cur = map.get(key);
                if (cur != null) return cur;

                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        min = Math.min(min, f(i + 1, k));
                    }
                }
                min += grid[i][j];
                map.put(key, min);
                return min;
            }
        }
     *
     * */

    /**
    *
        //ok, but TL

        class Solution {
            int[][] grid;
            int m;
            int n;
            Map<String, Integer> map = new HashMap<>();

            public int minFallingPathSum(int[][] grid) {
                this.grid = grid;
                m = grid.length;
                n = grid[0].length;
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    min = Math.min(min, f(0, i));
                }
                return min;
            }

            private int f(int i, int j) {
                if (i < 0 || j < 0 || i >= m || j >= n) {
                    return Integer.MAX_VALUE;
                }
                var key = i + "," + j;
                Integer cur = map.get(key);
                if (cur != null) return cur;

                if (i == m - 1) return grid[i][j];

                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        min = Math.min(min, f(i + 1, k));
                    }
                }
                min += grid[i][j];
                map.put(key, min);
                return min;
            }
        }
     *
     * */
}
