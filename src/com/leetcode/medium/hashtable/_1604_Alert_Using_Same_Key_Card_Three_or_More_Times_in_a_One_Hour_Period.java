package com.leetcode.medium.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class _1604_Alert_Using_Same_Key_Card_Three_or_More_Times_in_a_One_Hour_Period {
    //https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            int time = Integer.parseInt(keyTime[i].substring(0, 2)) * 60 + Integer.parseInt(keyTime[i].substring(3));
            map.computeIfAbsent(keyName[i], s -> new TreeSet<>()).add(time);
        }

        var answer = new TreeSet<String>();
        for (var entry: map.entrySet()) {
            var l = new ArrayList<>(entry.getValue());

            for (int j = 2; j < l.size(); j++) {
                if ((l.get(j) - l.get(j - 2) ) <= 60) {
                    answer.add(entry.getKey());
                    break;
                }
            }
        }
        return new ArrayList<String>(answer);
    }
}
