package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _819_Most_Common_Word {
    static public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        Set<String> ban = new HashSet<>();

        for (String s : banned) {
            ban.add(s.toLowerCase());
        }
        StringBuilder sb = new StringBuilder();

        for (Character ch : paragraph.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                sb.append(ch);
            } else {
                sb.append(' ');
            }
        }

        String[] arr = sb.toString().split(" ");

        Map<String, Integer> map = new HashMap<>();

        for (String s : arr) {
            s = s.trim();
            if (!s.equals("") && !ban.contains(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        String key = "";


        int max = 0;
        for (var entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                key = entry.getKey();
            }
        }

        return key;
    }

    public static void main(String[] args) {
        String[] a =  {"a"};
        System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c", a));
    }
}
