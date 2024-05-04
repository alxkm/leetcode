package com.leetcode.easy.math;

public class _3000_Maximum_Area_of_Longest_Diagonal_Rectangle {
    //3000. Maximum Area of Longest Diagonal Rectangle
    //https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/description/

    public int areaOfMaxDiagonal(int[][] dimensions) {
        double prevDiagonal = 0;
        int area = 0;
        for (int[] d: dimensions) {
            double curDiagonal = Math.sqrt(d[0]*d[0] + d[1]*d[1]);
            if (prevDiagonal < curDiagonal || (prevDiagonal == curDiagonal && area < (d[0] * d[1]))) {
                prevDiagonal = curDiagonal;
                area = d[0] * d[1];
            }
        }
        return area;
    }
}
