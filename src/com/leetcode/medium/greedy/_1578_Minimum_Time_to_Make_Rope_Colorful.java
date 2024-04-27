package com.leetcode.medium.greedy;

public class _1578_Minimum_Time_to_Make_Rope_Colorful {
    //1578. Minimum Time to Make Rope Colorful
    //https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/

    public int minCost(String colors, int[] neededTime) {
        int time = 0;
        char[] ca = colors.toCharArray();
        char ch = ca[0];
        int max = neededTime[0];

        for (int i = 1; i < ca.length; i++) {
            if (ca[i] == ch) {
                if (max <= neededTime[i]) {
                    time += max;
                    max = neededTime[i];
                } else {
                    time += neededTime[i];
                }
            } else {
                ch = ca[i];
                max = neededTime[i];
            }
        }

        return time;
    }
}
