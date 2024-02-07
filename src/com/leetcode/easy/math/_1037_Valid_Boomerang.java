package com.leetcode.easy.math;

public class _1037_Valid_Boomerang {
    //https://leetcode.com/problems/valid-boomerang/
    //1037. Valid Boomerang

    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0], y1 = points[0][1], x2 = points[1][0], y2 = points[1][1], x3 = points[2][0], y3 = points[2][1];
        int area = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
        return area != 0;
    }
}
