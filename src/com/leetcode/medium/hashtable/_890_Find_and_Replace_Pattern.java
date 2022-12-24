package com.leetcode.medium.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _890_Find_and_Replace_Pattern {
    static public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for (String s : words) {
            Map<Character, Character> map = new HashMap<>();
            boolean apply = true;
            for (int i = 0; i < pattern.length(); i++) {
                Character current = map.get(pattern.charAt(i));
                if (current == null) {
                    map.put(pattern.charAt(i), s.charAt(i));
                } else if (!(current == s.charAt(i))) {
                    apply = false;
                    break;
                }
            }
            if (apply) {
                Map<Character, Character> backMap = new HashMap<>();
                for (int i = 0; i < s.length(); i++) {
                    backMap.put(s.charAt(i), pattern.charAt(i));
                }
                if (backMap.size() == map.size()) {
                    list.add(s);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] strs = {"abc","deq","mee","aqq","dkd","ccc"};
        String p = "abb";

        System.out.println(findAndReplacePattern(strs, p));
    }
}
