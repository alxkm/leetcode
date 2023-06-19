package com.leetcode.easy.math;

public class _1184_Distance_Between_Bus_Stops {
    //https://leetcode.com/problems/distance-between-bus-stops/

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int s1 = 0, s2 = 0;
        if (start > destination) {
            for (int i = destination; i < start; i++) {
                s1 += distance[i];
            }
            for (int i = start; i < distance.length; i++) {
                s2 += distance[i];
            }
            for (int i = 0; i < destination; i++) {
                s2 += distance[i];
            }
        } else {
            for (int i = start; i < destination; i++) {
                s1 += distance[i];
            }
            for (int i = destination; i < distance.length; i++) {
                s2 += distance[i];
            }
            for (int i = 0; i < start; i++) {
                s2 += distance[i];
            }
        }
        return Math.min(s1, s2);
    }
}
