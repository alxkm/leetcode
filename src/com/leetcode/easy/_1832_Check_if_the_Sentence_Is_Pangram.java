package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1832_Check_if_the_Sentence_Is_Pangram {
    public boolean checkIfPangram(String sentence) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sentence.length(); i++) {
            Integer n = map.get(sentence.charAt(i));
            if (n != null) {
                map.put(sentence.charAt(i), ++n);
            } else {
                map.put(sentence.charAt(i), 1);
            }
        }
        return map.size() == 26;
    }

    public boolean checkIfPangram1(String sentence) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < sentence.length(); i++) {
            if (map.get(sentence.charAt(i)) == null) {
                map.put(sentence.charAt(i), sentence.charAt(i));
            } else {
                continue;
            }
        }
        return map.size() == 26;
    }

    public boolean checkIfPangram2(String sentence) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            set.add(sentence.charAt(i));
        }
        return set.size() == 26;
    }


    public boolean checkIfPangram3(String sentence) {
        if (sentence.length() < 26) return false;
        Object obj = new Object();
        Map<Character, Object> map = new HashMap<>();
        for (int i = 0; i < sentence.length(); i++) {
            if (map.get(sentence.charAt(i)) != null) {
                continue;
            } else {
                map.put(sentence.charAt(i), obj);
            }
        }
        return map.size() == 26;
    }
}
