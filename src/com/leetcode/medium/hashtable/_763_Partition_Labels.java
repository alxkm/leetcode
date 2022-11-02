package com.leetcode.medium.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _763_Partition_Labels {
    public List<Integer> partitionLabels(String s) {
        if (s.length() == 1) return List.of(1);
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            var a = map.get(s.charAt(i));
            if (a != null) {
                map.put(s.charAt(i), Math.max(i, a));
            } else {
                map.put(s.charAt(i), i);
            }
        }
        List<Integer> list = new ArrayList<>();
        if (s.length() == map.size()) {


            for (int i = 0; i < s.length(); i++) {
                list.add(1);
            }
            return list;
        }

        int counter = 0;
        int maxIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            var a = map.get(s.charAt(i));
            maxIndex = Math.max(a, maxIndex);
            counter++;
            if (i == maxIndex) {
                list.add(counter);
                counter = 0;
            }
        }
        return list;
    }
}
