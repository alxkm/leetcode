package com.leetcode.medium.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _539_Minimum_Time_Difference {
    //https://leetcode.com/problems/minimum-time-difference/?envType=daily-question&envId=2024-09-16
    //539. Minimum Time Difference

    public int findMinDifference(List<String> timePoints) {
        List<Integer> l = new ArrayList<>();

        for (String s : timePoints) {
            int hours = Integer.parseInt(s.substring(0, 2));
            int minutes = Integer.parseInt(s.substring(3, 5));
            int totalMinutes = hours * 60 + minutes;
            l.add(totalMinutes);
        }

        Collections.sort(l);

        int minDifference = Integer.MAX_VALUE;
        for (int i = 1; i < l.size(); i++) {
            minDifference = Math.min(minDifference, l.get(i) - l.get(i - 1));
        }


        int lastDifference = 1440 + l.get(0) - l.get(l.size() - 1);
        minDifference = Math.min(minDifference, lastDifference);

        return minDifference;
    }
}
