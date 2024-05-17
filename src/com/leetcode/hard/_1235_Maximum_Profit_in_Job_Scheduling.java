package com.leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1235_Maximum_Profit_in_Job_Scheduling {
    //1235. Maximum Profit in Job Scheduling
    //https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/

    private int[][] data;
    private int n;
    private Map<Integer, Integer> map = new HashMap<>();

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = profit.length;
        data = new int[n][3];

        for (int i = 0; i < n; i++) {
            data[i][0] = startTime[i];
            data[i][1] = endTime[i];
            data[i][2] = profit[i];
        }

        Arrays.sort(data, (x, y) -> x[0] - y[0]);

        return f(0);
    }

    private int f(int i) {
        if (i >= n) return 0;
        Integer val = map.get(i);
        if (val != null) return val;

        int j = i;
        while (++j < n) if (data[i][1] <= data[j][0]) break;

        val = f(i + 1);
        val = Math.max(data[i][2] + f(j), val);

        map.put(i, val);
        return val;
    }
}
