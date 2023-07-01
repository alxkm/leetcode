package com.leetcode.medium.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class _1657_Determine_if_Two_Strings_Are_Close {
    //https://leetcode.com/problems/determine-if-two-strings-are-close/

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            map1.put(word1.toCharArray()[i], map1.getOrDefault(word1.toCharArray()[i], 0) + 1);
            map2.put(word2.toCharArray()[i], map2.getOrDefault(word2.toCharArray()[i], 0) + 1);
        }
        List<Integer> values1 = map1.values().stream().sorted().collect(Collectors.toList());
        List<Integer> values2 = map1.values().stream().sorted().collect(Collectors.toList());
        if (values1.size() != values2.size()) return false;

        values1.removeAll(values2);

        return values1.size() == 0;

//        List<Character> removed = new ArrayList<>();
//        for (var entry : map1.entrySet()) {
//            var quantity = map2.get(entry.getKey());
//            if (quantity != null && quantity.equals(entry.getValue())) {
//                map2.remove(entry.getKey());
//                removed.add(entry.getKey());
//            } else if (quantity != null && quantity > 0) {
//                return false;
//            }
//        }
//        for (var character : removed) {
//            map1.remove(character);
//        }
//        if (map1.size() == 0 && map2.size() == 0) return true;
//
//        removed = new ArrayList<>();
//        for (var entry : map1.entrySet()) {
//            char ch = ' ';
//            for (var entry1 : map2.entrySet()) {
//                if (Objects.equals(entry1.getValue(), entry.getValue())) {
//                    ch = entry1.getKey();
//                    break;
//                }
//            }
//            if (ch == ' ') return false;
//            map2.remove(ch);
//            removed.add(entry.getKey());
//        }
//        if (map1.size() == 0 && map2.size() == 0) return true;
//
//        for (var character : removed) {
//            map1.remove(character);
//        }
//
//        return (map1.size() == 0 && map2.size() == 0);
    }

    public boolean closeStrings1(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        Set<Character> set = new HashSet<>();
        for (char ch: word1.toCharArray()) {
            a1[ch - 'a']++;
            set.add(ch);
        }
        for (char ch: word2.toCharArray()) {
            a2[ch - 'a']++;
            set.remove(ch);
        }
        Arrays.sort(a1);
        Arrays.sort(a2);

        return Arrays.toString(a1).equals(Arrays.toString(a2)) && set.size() == 0;
    }

    public static void main(String[] args) {
        _1657_Determine_if_Two_Strings_Are_Close solution = new _1657_Determine_if_Two_Strings_Are_Close();
        var word1 = "cabbba";
        var word2 = "abbccc";
        solution.closeStrings(word1, word2);
    }
}
