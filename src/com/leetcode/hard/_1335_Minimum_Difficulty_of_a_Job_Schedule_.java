package com.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class _1335_Minimum_Difficulty_of_a_Job_Schedule_ {
    //1335. Minimum Difficulty of a Job Schedule
    //https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/description/

    private int[] diff;
    private Map<String, Integer> cache = new HashMap<>();

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) return -1;
        diff = jobDifficulty;
        return dfs(0, d, -1);

        //int[][] dp = new int [jobDifficulty.length][d];
        //Use dp[i][j] where DP states are i the index of the last cut and j the number of remaining cuts.
        //Complexity is O(n * n * d).
    }

    private int dfs(int i, int d, int curMax) {
        if (i == diff.length) return (d == 0) ? 0 : Integer.MAX_VALUE - 1000;
        if (d == 0) return Integer.MAX_VALUE - 1000;

        String key = i + "," + d + "," + curMax;
        Integer cachedValue = cache.get(key);

        if (cachedValue != null) return cachedValue;

        curMax = Math.max(curMax, diff[i]);
        cachedValue = Math.min(
                dfs(i + 1, d, curMax),
                curMax + dfs(i + 1, d - 1, -1)
        );

        cache.put(key, cachedValue);
        return cache.get(key);
    }
}
