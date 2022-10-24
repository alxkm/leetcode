package com.company.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class _1160_Find_Words_That_Can_Be_Formed_by_Characters {
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

    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
                String chars = "atach";
        System.out.println(countCharacters(words, chars));
    }

}
