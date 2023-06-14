package com.leetcode.easy.intervals;

public class _2446_Determine_if_Two_Events_Have_Conflict {
    //2446. Determine if Two Events Have Conflict
    //https://leetcode.com/problems/determine-if-two-events-have-conflict/

    public boolean haveConflict(String[] event1, String[] event2) {
        int h1 = Integer.parseInt(event1[0].substring(0, 2));
        int m1 = Integer.parseInt(event1[0].substring(3, 5));

        int h11 = Integer.parseInt(event1[1].substring(0, 2));
        int m11 = Integer.parseInt(event1[1].substring(3, 5));

        int h2 = Integer.parseInt(event2[0].substring(0, 2));
        int m2 = Integer.parseInt(event2[0].substring(3, 5));

        int h22 = Integer.parseInt(event2[1].substring(0, 2));
        int m22 = Integer.parseInt(event2[1].substring(3, 5));

        int t11 = h1 * 60 + m1;
        int t12 = h11 * 60 + m11;
        int t21 = h2 * 60 + m2;
        int t22 = h22 * 60 + m22;

        return ((t11 <= t21 && t21 <= t12) || (t11 <= t22 && t22 <= t12)) ||
                ((t21 <= t11 && t11 <= t22) || (t21 <= t12 && t12 <= t22));
    }
}
