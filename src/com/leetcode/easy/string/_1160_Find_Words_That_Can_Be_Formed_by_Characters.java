package com.leetcode.easy.string;

import java.util.HashMap;
import java.util.Map;

public class _1160_Find_Words_That_Can_Be_Formed_by_Characters {
    //1160. Find Words That Can Be Formed by Characters
    //https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

    static public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < chars.length(); i++) {
            map.put(chars.charAt(i), map.getOrDefault(chars.charAt(i), 0) + 1);
        }
        int counter = 0;
        for (String w : words) {
            Map<Character, Integer> m = new HashMap<>();
            for (int j = 0; j < w.length(); j++) {
                m.put(w.charAt(j), m.getOrDefault(w.charAt(j), 0) + 1);
            }
            boolean b = true;

            for (Map.Entry<Character, Integer> entry : m.entrySet()) {
                Integer a = map.get(entry.getKey());
                if (a == null || a < entry.getValue()) {
                    b = false;
                    break;
                }
            }
            if (b) counter +=  w.length();
        }
        return counter;
    }

    public int countCharacters1(String[] words, String chars) {
        int[] map = new int[26];
        for (var ch: chars.toCharArray()) map[ch - 'a']++;
        int s = 0;
        for (var word: words) {
            if (word.length() > chars.length()) continue;
            int[] wFrequency = new int[26];
            for (var ch: word.toCharArray()) wFrequency[ch - 'a']++;

            boolean consists = true;
            for (var ch: word.toCharArray()) {
                if (wFrequency[ch - 'a'] > map[ch - 'a']) {
                    consists = false;
                    break;
                }
            }
            if (consists) s += word.length();
        }
        return s;
    }

    public int countCharacters2(String[] words, String chars) {
        int[] map = new int[26];
        for (var ch: chars.toCharArray()) map[ch - 'a']++;
        int s = 0;
        for (var word: words) {
            if (word.length() > chars.length()) continue;
            int[] freq = new int[26];
            boolean consists = true;
            for (var ch: word.toCharArray()) {
                freq[ch - 'a']++;
                if (freq[ch - 'a'] > map[ch - 'a']) {
                    consists = false;
                    break;
                }
            }
            if (consists) s += word.length();
        }
        return s;
    }

    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
                String chars = "atach";
        System.out.println(countCharacters(words, chars));
    }

}
