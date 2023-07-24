package com.leetcode.top.top175;

import java.util.HashMap;
import java.util.Map;

public class _451_Sort_Characters_By_Frequency {
    //451. Sort Characters By Frequency
    //https://leetcode.com/problems/sort-characters-by-frequency/

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        while (!map.keySet().isEmpty()) {
            char key = ' ';
            int value = Integer.MIN_VALUE;
            for (var entry: map.entrySet()) {
                if (entry.getValue() > value) {
                    key = entry.getKey();
                    value = entry.getValue();
                }
            }
            map.remove(key);
            for (int i = 0; i < value; i++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }
}
