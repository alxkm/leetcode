package com.leetcode.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _56_Merge_Intervals {
    //https://leetcode.com/problems/merge-intervals/
    //FOREIGN_SOLUTION

    public int[][] merge(int[][] in) {
        Arrays.sort(in, (a, b) ->  a[0] - b[0]);
        List<int []> l = new ArrayList<>();
        var newInterval = in[0];
        l.add(newInterval);
        for (var interval: in) {
            if (newInterval[1] >= interval[0]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                newInterval = interval;
                l.add(newInterval);
            }
        }
        return l.toArray(new int[l.size()][]);
    }
}
