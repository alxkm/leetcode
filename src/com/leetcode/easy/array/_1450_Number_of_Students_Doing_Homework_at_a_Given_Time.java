package com.leetcode.easy.array;

public class _1450_Number_of_Students_Doing_Homework_at_a_Given_Time {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int counter = 0;

        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) counter++;
        }

        return counter;
    }
}
