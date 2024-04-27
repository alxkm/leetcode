package com.leetcode.medium.dp;

import com.leetcode.Pair;

import java.util.HashMap;
import java.util.Map;

public class _931_Minimum_Falling_Path_Sum {
    //931. Minimum Falling Path Sum
    //https://leetcode.com/problems/minimum-falling-path-sum/description/

    int[][] matrix;
    int m;
    int n;
    Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        System.arraycopy(matrix[0], 0, dp[0], 0, n);

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + matrix[i][j];

                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + matrix[i][j]);
                }

                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1] + matrix[i][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[m - 1][j]);
        }

        return min;
    }

    private int f(int i, int j, int curSum) {
        if (i >= m) return curSum;
        if (i < 0 || j >= n || j < 0) return Integer.MAX_VALUE;
        var cachedVal = map.get(new Pair<>(i, j));
        if (cachedVal != null) return cachedVal;
        curSum += matrix[i][j];

        int f = f(i + 1, j, curSum);
        int s = f(i + 1, j + 1, curSum);
        int t = f(i + 1, j - 1, curSum);

        int min = Math.min(Math.min(f, s), t);
        map.put(new Pair<>(i, j), min);

        return min;
    }

    public static void main(String[] args) {
        var sol = new _931_Minimum_Falling_Path_Sum();
        int[][] matrix1 = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        int[][] matrix = {
                {10,-98,44},
                {-20,65,34},
                {-100,-1,74}
        };
        System.out.println(sol.minFallingPathSum(matrix));
        System.out.println();
    }

}
