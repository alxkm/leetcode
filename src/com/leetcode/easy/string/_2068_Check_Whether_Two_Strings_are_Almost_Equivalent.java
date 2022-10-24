package com.company.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _2068_Check_Whether_Two_Strings_are_Almost_Equivalent {
    static     public boolean checkAlmostEquivalent(String word1, String word2) {
        Set<Character> s = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < word1.length(); i++) {
            map.put(word1.charAt(i), map.getOrDefault(word1.charAt(i), 0) + 1);
            s.add(word1.charAt(i));
        }
        Map<Character, Integer> map1 = new HashMap<>();
        for(int i = 0; i < word1.length(); i++) {
            map.put(word1.charAt(i), map.getOrDefault(word1.charAt(i), 0) + 1);
            s.add(word2.charAt(i));
        }
        for (Character c : s) {
            if (Math.abs(map.getOrDefault(c, 0) - map1.getOrDefault(c, 0)) > 3) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkAlmostEquivalent("abcdeef",
                                                 "abaaacc"));
    }
}
