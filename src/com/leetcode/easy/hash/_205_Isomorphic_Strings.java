package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _205_Isomorphic_Strings {
    //205. Isomorphic Strings
    //https://leetcode.com/problems/isomorphic-strings/description/

    static public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> m1 = new HashMap<>();
        Map<Character, Character> m2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character w1 = s.charAt(i);
            Character w2 = t.charAt(i);

            Character s1 = m1.get(w1);
            Character s2 = m2.get(w2);

            if (s1 == w2 && s2 == w1) continue;

            if (s1 == null && s2 == null) {
                m1.put(w1, w2);
                m2.put(w2, w1);
                continue;
            }

            return false;
        }
        return true;
    }

    public boolean isIsomorphic1(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> ar = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            var ch = map.get(ch1);
            if (ch == null) {
                if (ar.contains(ch2)) return false;
                ar.add(ch2);
                map.put(ch1, ch2);
                continue;
            }
            if (ch2 != ch) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("add", "egg"));
    }
}
