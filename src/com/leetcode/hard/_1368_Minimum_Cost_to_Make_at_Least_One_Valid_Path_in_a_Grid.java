package com.leetcode.hard;

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;

public class _1368_Minimum_Cost_to_Make_at_Least_One_Valid_Path_in_a_Grid {
    //1368. Minimum Cost to Make at Least One Valid Path in a Grid
    //https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description/

    public static final int[][] dxdy = new int[][]{{0, 1, 1}, {0, -1, 2}, {1, 0, 3}, {-1, 0, 4}};

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] minCost = new int[m][n];
        for (int[] row : minCost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerFirst(new int[]{0, 0});
        minCost[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int row = cur[0];
            int col = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int newRow = row + dxdy[dir][0];
                int newCol = col + dxdy[dir][1];
                int cost = (grid[row][col] == dxdy[dir][2]) ? 0 : 1;

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&

                        minCost[row][col] + cost < minCost[newRow][newCol]) {

                    minCost[newRow][newCol] = minCost[row][col] + cost;
                    if (cost == 0) {
                        deque.offerFirst(new int[]{newRow, newCol});
                    } else {
                        deque.offerLast(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return minCost[m - 1][n - 1];
    }
}
