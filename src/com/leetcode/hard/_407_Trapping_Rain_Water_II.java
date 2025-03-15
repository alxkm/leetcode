package com.leetcode.hard;

import java.util.PriorityQueue;

public class _407_Trapping_Rain_Water_II {
    //407. Trapping Rain Water II
    //https://leetcode.com/problems/trapping-rain-water-ii/description/
    //BFS

    public int trapRainWater(int[][] heightMap) {
        int ROWS = heightMap.length;
        int COLS = heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if ((i == 0 || i == ROWS - 1) || (j == 0 || j == COLS - 1)) {
                    pq.offer(new int[] {heightMap[i][j], i, j});
                    heightMap[i][j] = -1;
                }
            }
        }

        int res = 0;
        int maxH = -1;

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int h = p[0], r = p[1], c = p[2];
            maxH = Math.max(maxH, h);
            res += maxH - h;

            int[][] neighbors = new int[][] {{r + 1, c}, {r - 1, c}, {r, c + 1}, {r, c - 1}};
            for (var ar: neighbors) {
                int nr = ar[0];
                int nc = ar[1];

                if (nr < 0 || nc < 0 || nr == ROWS || nc == COLS || heightMap[nr][nc] == -1) continue;

                pq.offer(new int[] {heightMap[nr][nc], nr, nc});
                heightMap[nr][nc] = -1;
            }
        }
        return res;
    }
}
