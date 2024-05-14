package com.leetcode.medium.backtrack;

public class _1219_Path_with_Maximum_Gold {
    //1219. Path with Maximum Gold
    //https://leetcode.com/problems/path-with-maximum-gold/

    int n;
    int m;
    int[][] grid;
    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    max = Math.max(max, dfs(i, j, new boolean[m][n], 0));
                }
            }
        }
        return max;
    }

    private int dfs(int i, int j, boolean[][] used, int sum) {
        if (i >= m || j >= n || i < 0 || j < 0 || used[i][j] || grid[i][j] == 0) return sum;

        used[i][j] = true;
        sum += grid[i][j];

        int a = dfs(i + 1, j, used, sum);
        int b = dfs(i, j + 1, used, sum);
        int c = dfs(i - 1, j, used, sum);
        int d = dfs(i , j - 1, used, sum);
        used[i][j] = false;
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }

    public static void main(String[] args) {
        var sol = new _1219_Path_with_Maximum_Gold();
        int[][] ar = new int[][] {
                {0,6,0},
                {5,8,7},
                {0,9,0}
        };
        int[][] ar1 = new int[][] {
                {1,0,7,0,0,0},
                {2,0,6,0,1,0},
                {3,5,6,7,4,2},
                {4,3,1,0,2,0},
                {3,0,5,0,20,0}
        };
        System.out.println(sol.getMaximumGold(ar1));
    }
}
