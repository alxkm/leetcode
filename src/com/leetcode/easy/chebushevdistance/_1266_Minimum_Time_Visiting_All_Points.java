package com.leetcode.easy.chebushevdistance;

public class _1266_Minimum_Time_Visiting_All_Points {
    //https://leetcode.com/problems/minimum-time-visiting-all-points/
    //1266. Minimum Time Visiting All Points

    public int minTimeToVisitAllPoints(int[][] points) {
        if (points.length == 1) return 0;

        int[] p = points[0];
        int t = 0;
        for (int i = 1; i < points.length; i++) {
            int[] p1 = points[i];

            while (p[0] != p1[0] || p[1] != p1[1]) {
                if (p[0] < p1[0]) {
                    p[0]++;
                } else if (p[0] > p1[0]) {
                    p[0]--;
                }

                if (p[1] < p1[1]) {
                    p[1]++;
                } else if (p[1] > p1[1]) {
                    p[1]--;
                }
                t++;
            }
            p = p1;
        }
        return t;
    }

    public int minTimeToVisitAllPoints1(int[][] points) {
        if (points.length == 1) return 0;
        int t = 0;
        for (int i = 1; i < points.length; i++) {
            t += Math.max(Math.abs(points[i][0] - points[i - 1][0]), Math.abs(points[i][1] - points[i - 1][1]));
        }
        return t;
    }

}
