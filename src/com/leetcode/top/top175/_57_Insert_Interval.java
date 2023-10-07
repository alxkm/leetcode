package com.leetcode.top.top175;

import java.util.ArrayList;
import java.util.List;

public class _57_Insert_Interval {
    //https://leetcode.com/problems/insert-interval/
    //FOREIGN_SOLUTION
    //TOP

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                list.add(newInterval);
                newInterval = intervals[i];
            } else if (intervals[i][1] >= newInterval[0])
                newInterval = new int[] {Math.min(intervals[i][0], newInterval[0]),
                        Math.max(intervals[i][1], newInterval[1]) };
            else
                list.add(intervals[i]);
        }
        list.add(newInterval);
        return list.toArray(new int[list.size()][2]);
    }

}
