package com.leetcode.medium.chebushev;

public class _2849_Determine_if_a_Cell_Is_Reachable_at_a_Given_Time {
    //https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/
    //2849. Determine if a Cell Is Reachable at a Given Time

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy && t == 1) return false;
        return Math.max(Math.abs(sx - fx), Math.abs(sy - fy)) <= t;
    }
}
