package com.leetcode.medium.simulation;

public class _1503_Last_Moment_Before_All_Ants_Fall_Out_of_a_Plank {
    //https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
    //1503. Last Moment Before All Ants Fall Out of a Plank

    public int getLastMoment(int n, int[] left, int[] right) {
        int m = 0;
        for (int i = 0; i < left.length; i++) {
            m = Math.max(m, left[i]);
        }
        for (int i = 0; i < right.length; i++) {
            m = Math.max(m, n - right[i]);
        }
        return m;
    }
}
