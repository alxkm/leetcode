package com.leetcode.medium.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1817_Finding_the_Users_Active_Minutes {
    static public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> userMap = new HashMap<>();
        for (int[] log : logs) {
            Set<Integer> userTimeSet = userMap.getOrDefault(log[0], new HashSet<>());
            userTimeSet.add(log[1]);
            userMap.put(log[0], userTimeSet);
        }

        int[] result = new int[k];

        for (var entry : userMap.entrySet()) {
            result[entry.getValue().size() - 1]++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] logs = {{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}};
        int k = 5;
        System.out.println(Arrays.toString(findingUsersActiveMinutes(logs, k)));
    }
}
