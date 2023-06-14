package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.Map;

public class _290_Word_Pattern {
    //https://leetcode.com/problems/word-pattern/

    static public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();

        String[] words = s.split(" ");

        if (pattern.length() != words.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            String word = words[i];
            String w = map.get(pattern.charAt(i));
            if (w != null && w.equals(word)) continue;
            if (w != null) return false;
            if (map.containsValue(word)) return false;
            map.put(pattern.charAt(i), word);
        }
        return true;
    }

    public boolean wordPattern1(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] array = s.split(" ");
        if (array.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            var storedWord = map.get(pattern.charAt(i));
            if (storedWord == null) {
                if (map.values().contains(array[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), array[i]);
                continue;
            }
            if (storedWord != null && !storedWord.equals(array[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abba";
        String s1 = "dog dog dog dog";

        System.out.println(wordPattern(s, s1));
    }
}
