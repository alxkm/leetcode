package com.leetcode.medium.binsearch;

import java.util.Arrays;

public class _1011_Capacity_To_Ship_Packages_Within_D_Days {
    //https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

    public int shipWithinDays(int[] weights, int days) {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();

        while (l < r) {
            int m = (l + r) / 2;
            if (f(weights, days, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean f(int[] weights, int days,  int c) {
        int daysNeeded = 1, currentLoad = 0;
        for (int w : weights) {
            currentLoad += w;
            if (currentLoad > c) {
                daysNeeded++;
                currentLoad = w;
            }
        }
        return daysNeeded <= days;
    }
}
