package com.leetcode.top.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class _994_Rotting_Oranges {
    //https://leetcode.com/problems/rotting-oranges/
    //994. Rotting Oranges

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int freshOrange = 0;
        int commonCounter = 0;
        int nonCounter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOrange++;
                } else {
                    nonCounter++;
                }
                commonCounter++;
            }
        }

        if (nonCounter == commonCounter) return 0;
        if (freshOrange == 0 && q.size() > 0) return 0;
        if (commonCounter == q.size()) return 0;
        if (commonCounter == freshOrange || q.size() == 0) return -1;

        int counter = 0;
        int rottenOrange = 0;
        while (!q.isEmpty()) {
            Queue<int[]> q1 = new LinkedList<>();
            while (!q.isEmpty()) {
                int[] a = q.poll();

                int i = a[0];
                int j = a[1];

                grid[i][j] = 2;

                if (check(i + 1, j, grid)) {
                    q1.add(new int[]{i + 1, j});
                    grid[i + 1][j] = 2;
                    rottenOrange++;
                }
                if (check(i, j + 1, grid)) {
                    q1.add(new int[]{i, j + 1});
                    grid[i][j + 1] = 2;
                    rottenOrange++;
                }
                if (check(i - 1, j, grid)) {
                    q1.add(new int[]{i - 1, j});
                    grid[i - 1][j] = 2;
                    rottenOrange++;
                }
                if (check(i, j - 1, grid)) {
                    q1.add(new int[]{i, j - 1});
                    grid[i][j - 1] = 2;
                    rottenOrange++;
                }
            }
            counter++;
            if (freshOrange == rottenOrange) {
                return counter;
            }
            q = q1;
        }
        if (freshOrange == rottenOrange) {
            return counter;
        }
        return -1;
    }

    private boolean check(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] == 0 || grid[i][j] == 2) {
            return false;
        }
        return true;
    }
}
