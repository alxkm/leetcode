package com.leetcode.easy.string.additional;

import java.util.HashMap;
import java.util.Map;

public class _1897_Redistribute_Characters_to_Make_All_Strings_Equal {
    static public boolean makeEqual(String[] words) {
        if (words.length == 1) return true;
        Map<Character, Integer> map = new HashMap<>();

        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
        }

        for (var entry : map.entrySet()) {
            if (entry.getValue() % words.length != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = {"caaaaa","aaaaaaaaa","a","bbb","bbbbbbbbb","bbb","cc","cccccccccccc","ccccccc","ccccccc","cc","cccc","c","cccccccc","c"};

        System.out.println(makeEqual(a));
    }
}
