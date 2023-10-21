package com.leetcode.medium.math;

public class _223_Rectangle_Area {
    //https://leetcode.com/problems/rectangle-area/
    //223. Rectangle Area
    //FOREIGN_SOLUTION

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int ar1 = (ax2 - ax1) * (ay2 - ay1);
        int ar2 = (bx2 - bx1) * (by2 - by1);

        int x1 = Math.max(ax1, bx1);
        int x2 = Math.min(ax2, bx2);

        int y1 = Math.max(ay1, by1);
        int y2 = Math.min(ay2, by2);

        int a = (x2 - x1);
        int b = (y2 - y1);

        int ac = 0;
        if (a > 0 && b > 0) ac = a * b;

        return ar1 + ar2 - ac;
    }
}
