package com.leetcode.K_package;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class _692_Top_K_Frequent_Words {
    //692. Top K Frequent Words
    //https://leetcode.com/problems/top-k-frequent-words/

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        Map<Integer, SortedSet<String>> fr = new TreeMap<>(Comparator.reverseOrder());
        for (var entry : map.entrySet()) {
            fr.computeIfAbsent(entry.getValue(), key -> new TreeSet<>()).add(entry.getKey());
        }

        List<String> l = new ArrayList<>();
        for (var entry : fr.entrySet()) {
            for (String s : entry.getValue()) {
                if (k-- > 0) l.add(s);
                else return l;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        var sol = new _692_Top_K_Frequent_Words();
        System.out.println(sol.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 3));
    }
}
