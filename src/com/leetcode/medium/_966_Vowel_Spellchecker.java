package com.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _966_Vowel_Spellchecker {
    //966. Vowel Spellchecker
    //https://leetcode.com/problems/vowel-spellchecker/

    Map<String, String> lower;
    Map<String, String> vowel;
    Set<String> voc;

    public String[] spellchecker(String[] wordlist, String[] queries) {
        lower = new HashMap<>();
        vowel = new HashMap<>();
        voc = new HashSet<>();

        for (String s : wordlist) {
            voc.add(s);
            String wordLower = s.toLowerCase();
            lower.putIfAbsent(wordLower, s);
            vowel.putIfAbsent(devowel(wordLower), s);
        }

        for (int i = 0; i < queries.length; i++) {
            queries[i] = getWord(queries[i]);
        }

        return queries;
    }

    private String getWord(String s) {
        if (voc.contains(s)) return s;
        String lowCased = s.toLowerCase();
        if (lower.containsKey(lowCased)) return lower.get(lowCased);
        String dw = devowel(lowCased);
        if (vowel.containsKey(dw)) return vowel.get(dw);
        return "";
    }

    String devowel(String s) {
        StringBuilder sb = new StringBuilder();
        Set<Character> v = Set.of('a', 'e', 'i', 'o', 'u');
        for (char c : s.toCharArray()) {
            sb.append(v.contains(c) ? '*' : c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var sol = new _966_Vowel_Spellchecker();
        //"kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"
        System.out.println(Arrays.toString(sol.spellchecker(new String[]{"KiTe", "kite", "hare", "Hare"},
                new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"})));
    }
}
