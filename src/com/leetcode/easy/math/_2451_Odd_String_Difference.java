package com.leetcode.easy.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2451_Odd_String_Difference {
    //https://leetcode.com/problems/odd-string-difference/

    public String oddString(String[] words) {
        Map<String, Integer> compareMap = new HashMap<>();
        for (var s: words) {
            compareMap.put(s, compareMap.getOrDefault(s, 0) + 1);
        }
        if (compareMap.size() == 2) {
            for (var entry: compareMap.entrySet()) {
                if (entry.getValue() == 1) return entry.getKey();
            }
        }

        Map<String, List<Integer>> map = new HashMap<>();
        for (String s: words) {
            List<Integer> l = new ArrayList<>();
            char[] chars = s.toCharArray();
            for (int i = 1; i < s.length(); i++) {
                l.add((chars[i] - 'a') - (chars[i - 1] - 'a'));
            }
            map.put(s, l);
        }
        Map<List<Integer>, Integer> counter = new HashMap<>();

        for (var entry: map.entrySet()) {
            counter.put(entry.getValue(), counter.getOrDefault(entry.getValue(), 0) + 1);
        }

        for (var entry: counter.entrySet()) {
            if (entry.getValue() == 1) {
                for (var entry1: map.entrySet()) {
                    if (cmp(entry1.getValue(), entry.getKey())) {
                        return entry1.getKey();
                    }
                }
            }
        }
        return "";
    }

    private boolean cmp(List<Integer> l1, List<Integer> l2) {
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) != l2.get(i)) return false;
        }
        return true;
    }
}
