package com.leetcode.easy.math;

public class _2651_Calculate_Delayed_Arrival_Time {
    //2651. Calculate Delayed Arrival Time
    //https://leetcode.com/problems/calculate-delayed-arrival-time/description/

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
