package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.Map;

public class _1941_Check_if_All_Characters_Have_Equal_Number_of_Occurrences {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (Character ch : s.toCharArray()) {
            Integer i = map.get(ch);
            if (i != null) {
                map.put(ch, ++i);
                continue;
            }
            map.put(ch, 1);
        }

        int n = map.get(s.charAt(0));

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != n) return false;
        }
        return true;
    }
}
