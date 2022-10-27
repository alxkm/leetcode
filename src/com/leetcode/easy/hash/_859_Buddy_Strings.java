package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class _859_Buddy_Strings {
    static public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length() || s.length() == 1) return false;
        boolean is = true;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                is = false;
                break;
            }
        }
        if (is && s.equals(goal)) return true;
        if (is && !s.equals(goal)) return false;
        Map<Character, Integer> set = new HashMap<>();
        Map<Character, Integer> set1 = new HashMap<>();
        if (s.equals(goal)) {
            for (int i = 0; i < s.length(); i++) {
                set.put(s.charAt(i), set.getOrDefault(s.charAt(i), 0) + 1);
                set1.put(goal.charAt(i), set.getOrDefault(goal.charAt(i), 0) + 1);

            }
        }

        for (int i = 0; i < s.length(); i++) {
            set.put(s.charAt(i), set.getOrDefault(s.charAt(i), 0) + 1);
            set1.put(goal.charAt(i), set.getOrDefault(goal.charAt(i), 0) + 1);
            if (s.charAt(i) != goal.charAt(i)) {
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i)) {
                        StringBuilder sb = new StringBuilder();

                        sb.append(s.substring(0, i))
                                .append(s.charAt(j))
                                .append(s.substring(i + 1, j))
                                .append(s.charAt(i))
                                .append(s.substring(j + 1));
                        if (sb.toString().equals(goal)) return true;

                    }
                }
            }
        }

        if (set1.keySet().size() == set.keySet().size()) {
            for (var e : set.entrySet()) {
                if (!Objects.equals(set1.get(e.getKey()), e.getValue())) {
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // String s = "abcdef", goal = "abfdec";
        // String s = "aa", goal = "aa";
        // String s = "ab", goal = "ab";
        // String s = "ab", goal = "ba";
        // String s = "abab", goal ="abab";
       String s = "abcaa", goal = "abcbb";
       System.out.println(buddyStrings(s, goal));
    }
}
