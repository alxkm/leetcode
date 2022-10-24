package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class _2351_First_Letter_to_Appear_Twice {
    public char repeatedCharacter(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer c = map.get(s.charAt(i));
            if (c != null) {
                return s.charAt(i);
            } else {
                map.put(s.charAt(i), Integer.valueOf(1));
            }
        }
        return 'a';
    }
}
