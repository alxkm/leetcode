package com.leetcode.medium.sort;

import java.util.Arrays;

public class _1637_Widest_Vertical_Area_Between_Two_Points_Containing_No_Points {
    //https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/description/
    //1637. Widest Vertical Area Between Two Points Containing No Points

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (x, y) -> x[0] - y[0]);
        int w = 0;
        for (int i = 1; i < points.length; i++) {
            w = Math.max(w, points[i][0] - points[i - 1][0]);
        }
        return w;
    }
}
