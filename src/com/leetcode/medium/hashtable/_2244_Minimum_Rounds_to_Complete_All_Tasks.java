package com.leetcode.medium.hashtable;

import java.util.HashMap;
import java.util.Map;

public class _2244_Minimum_Rounds_to_Complete_All_Tasks {
    //2244. Minimum Rounds to Complete All Tasks
    //https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: tasks) map.put(n, map.getOrDefault(n, 0) + 1);

        int counter = 0;
        for (var e: map.entrySet()) {
            if (e.getValue() == 1) return -1;
            if (e.getValue() % 3 == 0) counter += e.getValue() / 3;
            else counter += (e.getValue() / 3 + 1);
        }
        return counter;
    }
}
