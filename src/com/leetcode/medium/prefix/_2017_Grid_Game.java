package com.leetcode.medium.prefix;

public class _2017_Grid_Game {
    //https://leetcode.com/problems/grid-game/description/
    //2017. Grid Game

    class Solution {
        public long gridGame(int[][] grid) {
            int n = grid[0].length;
            long[] topPrefix = new long[n + 1];
            long[] bottomPrefix = new long[n + 1];

            for (int i = n - 1; i >= 0; i--) {
                topPrefix[i] = topPrefix[i + 1] + grid[0][i];
            }

            for (int i = 0; i < n; i++) {
                bottomPrefix[i + 1] = bottomPrefix[i] + grid[1][i];
            }

            long result = Long.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                long topRemain = topPrefix[i + 1];
                long bottomRemain = bottomPrefix[i];
                long secondRobotPoints = Math.max(topRemain, bottomRemain);
                result = Math.min(result, secondRobotPoints);
            }

            return result;
        }
    }
}
