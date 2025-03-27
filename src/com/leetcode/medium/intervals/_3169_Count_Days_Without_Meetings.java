package com.leetcode.medium.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class _3169_Count_Days_Without_Meetings {
    //3169. Count Days Without Meetings
    //https://leetcode.com/problems/count-days-without-meetings/description/?envType=daily-question&envId=2025-03-24

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int freeDays = 0, latestEnd = 0;

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            if (start > latestEnd + 1) {
                freeDays += start - latestEnd - 1;
            }

            latestEnd = Math.max(latestEnd, end);
        }

        freeDays += days - latestEnd;

        return freeDays;
    }
}
