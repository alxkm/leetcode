package com.leetcode.top.top175;

import java.util.Arrays;

public class _452_Minimum_Number_of_Arrows_to_Burst_Balloons {
    //https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
    //greedy
    //PART_SOLUTION

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (x, y) -> Integer.compare(x[1], y[1]));
        int counter = 1;
        int prevEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= prevEnd) {
                continue;
            } else {
                counter++;
                prevEnd = points[i][1];
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        var solution = new _452_Minimum_Number_of_Arrows_to_Burst_Balloons();

        int[][] ar = new int[][]{{10,16},{2,8},{1,6},{7,12}};
        int[][] ar1 = new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
        int[][] ar2 = new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        solution.findMinArrowShots(ar2);
    }
}
