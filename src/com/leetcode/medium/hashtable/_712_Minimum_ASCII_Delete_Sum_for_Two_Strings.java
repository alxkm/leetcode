package com.leetcode.medium.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _712_Minimum_ASCII_Delete_Sum_for_Two_Strings {
    //https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
    //FOREIGN_SOLUTION

    public int minimumDeleteSum(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char ch: s1.toCharArray()) map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        for (char ch: s2.toCharArray()) map2.put(ch, map2.getOrDefault(ch, 0) + 1);

        int sum = 0;

        for (var entry: map1.entrySet()) {
            int q1 = entry.getValue();
            var q2 = map2.get(entry.getKey());
            if (q2 == null) {
                sum += (q1 * (int)entry.getKey());
            } else {
                if (q1 == q2) {
                    continue;
                } else {
                    sum += (Math.abs(q1 - q2) * (int)entry.getKey());
                }
            }
        }
        Set<Character> set = new HashSet<>(map2.keySet());
        set.removeAll(map1.keySet());
        for (char ch: set) {
            int q = map2.get(ch);
            sum += (q * (int)ch);
        }
        return sum;
    }
}
