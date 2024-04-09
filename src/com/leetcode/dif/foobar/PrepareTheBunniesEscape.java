package com.leetcode.dif.foobar;

public class PrepareTheBunniesEscape {
    public static int solution(int[][] a) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1) {
                    a[i][j] = 0;
                    int distance = bfs(a);
                    if (distance != -1) {
                        min = Math.min(min, distance);
                    }
                    a[i][j] = 1;
                }
            }
        }
        return min;
    }

    private static int bfs(int[][] a) {
        java.util.Queue<Point> q = new java.util.LinkedList<>();
        q.offer(new Point(0, 0, 0));
        int m = a.length;
        int n = a[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point current = q.poll();
            if (current.x == m - 1 && current.y == n - 1) {
                return current.distance;
            }

            int[][] ds = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            for (int[] dss : ds) {
                int dx = current.x + dss[0];
                int dy = current.y + dss[1];
                if (dx < m && dy < n && dx >= 0 && dy >= 0 && !visited[dx][dy] && a[dx][dy] == 0) {
                    q.offer(new Point(dx, dy, current.distance + 1));
                    visited[dx][dy] = true;
                }
            }
        }
        return -1;
    }

    static class Point {
        int x;
        int y;
        int distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        int[][] a = {
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
        };
        System.out.println(solution(a));
    }
}
