package com.leetcode.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2406_Divide_Intervals_Into_Minimum_Number_of_Groups {
    //2406. Divide Intervals Into Minimum Number of Groups
    //https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/description/

    public int minGroups(int[][] intervals) {
        List<int[]> events = new ArrayList<>();
        for (int[] in : intervals) {
            events.add(new int[] {in[0], 1});
            events.add(new int[] {in[1] + 1, -1});
        }

        Collections.sort(events, (x, y) -> {
            if (x[0] == y[0]) return Integer.compare(x[1], y[1]);
            return Integer.compare(x[0], y[0]);
        });

        int maxIntersection = 1;
        int intersectionCounter = 0;
        for (int[] in: events) {
            intersectionCounter += in[1];
            maxIntersection = Math.max(maxIntersection, intersectionCounter);
        }
        return maxIntersection;
    }
}
