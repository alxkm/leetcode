package com.company.hash;

import java.util.HashMap;
import java.util.Map;

public class _205_Isomorphic_Strings {
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

    public static void main(String[] args) {
        System.out.println(isIsomorphic("add", "egg"));
    }
}
