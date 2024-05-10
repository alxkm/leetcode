package com.leetcode.medium.graph;

import com.leetcode.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _1091_Shortest_Path_in_Binary_Matrix {
    //https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
    //1091. Shortest Path in Binary Matrix

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[][] dxdy = new int[][]{new int[]{-1, 1}, new int[]{1, -1}, new int[]{-1, -1}, new int[]{1, 1}, new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, 1}, new int[]{0, -1}};
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        boolean[][] visited = new boolean[n][n];
        int[][] dist = new int[n][n];
        dist[0][0] = 0;
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            var p = queue.poll();
            if (grid[p.getKey()][p.getValue()] == 1) continue;

            for (int[] d : dxdy) {
                int dx = d[0] + p.getKey();
                int dy = d[1] + p.getValue();
                if (dx >= 0 && dx < n && dy >= 0 && dy < n) {
                    if (grid[dx][dy] == 0 && !visited[dx][dy]) {
                        visited[dx][dy] = true;

                        dist[dx][dy] = dist[p.getKey()][p.getValue()] + 1;
                        queue.add(new Pair<>(dx, dy));
                    }
                }
            }
        }

        return dist[n - 1][n - 1] == 0 ? -1 : dist[n - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] ar1 = {{0,0,0},
                       {1,1,0},
                       {1,1,0}};
        int[][] ar  = {{1,0,0},
                       {1,1,0},
                       {1,1,0}};
        var sol = new _1091_Shortest_Path_in_Binary_Matrix();
        System.out.println(sol.shortestPathBinaryMatrix(ar1));
    }
}
