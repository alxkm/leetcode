package com.leetcode.medium.math;

public class _1828_Queries_on_Number_of_Points_Inside_a_Circle {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] answer = new int[queries.length];
        int i = 0;
        for (int[] q : queries) {
            int counter = 0;
            for (int[] p : points) {
                if (isInCircle(p[0], p[1], q[0], q[1], q[2])) {
                    counter++;
                }
            }
            answer[i++] = counter;
        }
        return answer;
    }

    private boolean isInCircle(int x, int y, int cx, int cy, int r) {
        return Math.sqrt(Math.pow((x - cx), 2) + Math.pow((y - cy), 2)) <= r;
    }
}
