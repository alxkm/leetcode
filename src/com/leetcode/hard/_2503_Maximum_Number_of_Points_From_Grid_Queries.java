package com.leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _2503_Maximum_Number_of_Points_From_Grid_Queries {
    //2503. Maximum Number of Points From Grid Queries
    //https://leetcode.com/problems/maximum-number-of-points-from-grid-queries/description/?envType=daily-question&envId=2025-03-28

    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int[] answer = new int[queries.length];

        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i] = new int[]{queries[i], i};
        }
        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[m][n];

        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int count = 0, maxValue = 0;

        for (int[] q : sortedQueries) {
            int queryValue = q[0], index = q[1];

            while (!pq.isEmpty() && pq.peek()[0] < queryValue) {
                int[] cell = pq.poll();
                int value = cell[0], x = cell[1], y = cell[2];

                count++;
                maxValue = Math.max(maxValue, value);

                for (int[] d : directions) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                        pq.offer(new int[]{grid[nx][ny], nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }

            answer[index] = count;
        }

        return answer;
    }
}
