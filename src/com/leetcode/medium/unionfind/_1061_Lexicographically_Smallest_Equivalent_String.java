package com.leetcode.medium.unionfind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class _1061_Lexicographically_Smallest_Equivalent_String {
    //1061. Lexicographically Smallest Equivalent String
    //https://leetcode.com/problems/lexicographically-smallest-equivalent-string/

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            var l1 = map.get(ch1);
            var l2 = map.get(ch2);
            if (l1 == null) map.put(ch1, new HashSet<>());
            if (l2 == null) map.put(ch2, new HashSet<>());
            map.get(ch1).add(ch2);
            map.get(ch2).add(ch1);
        }
        Map<Character, SortedSet<Character>> sorted = new HashMap<>();
        Set<Character> visit = new HashSet<>();
        for (char ch: map.keySet()) {
            if (!visit.contains(ch)) {
                SortedSet<Character> sortedSet = new TreeSet<>();
                dfs(ch, sortedSet, map, visit);
                for (Character s: sortedSet) {
                    sorted.put(s, sortedSet);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char ch: baseStr.toCharArray()) {
            if (sorted.get(ch) == null) sb.append(ch);
            else sb.append(sorted.get(ch).first());
        }
        return sb.toString();
    }

    private void dfs(Character cur, SortedSet<Character> container, Map<Character, Set<Character>> map, Set<Character> visit) {
        if (visit.contains(cur)) return;

        visit.add(cur);
        container.add(cur);
        for (var ch: map.get(cur)) {
            dfs(ch, container, map, visit);
        }
    }
}
