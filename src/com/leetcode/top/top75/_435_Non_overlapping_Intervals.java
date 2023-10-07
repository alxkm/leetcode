package com.leetcode.top.top75;

import java.util.Arrays;

public class _435_Non_overlapping_Intervals {
    //435. Non-overlapping Intervals
    //https://leetcode.com/problems/non-overlapping-intervals/
    //FOREIGN_SOLUTION
    //TOP

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int counter = 0;
        int prev = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (prev <= intervals[i][0]) {
                prev = intervals[i][1];
            } else {
                prev = Math.min(prev, intervals[i][1]);
                counter++;
            }
        }
        return counter;
    }
}
