package com.leetcode.easy.string.additional;

import java.util.HashMap;
import java.util.Map;

public class _953_Verifying_an_Alien_Dictionary {
    static public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1) return true;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            var cur = words[i];
            var prev = words[i - 1];

            boolean allEqual = false;
            boolean is = false;
            for (int j = 0; j < cur.length() && j < prev.length(); j++) {
                char curChar = cur.charAt(j);
                Integer curCharIndex = map.get(curChar);
                char prevChar = prev.charAt(j);
                Integer prevCharIndex = map.get(prevChar);
                if (curCharIndex == prevCharIndex) {
                    allEqual = true;
                    continue;
                }
                if (curCharIndex > prevCharIndex) {
                    allEqual = false;
                    is = true;
                    break;
                } else {
                    return false;
                }
            }
            if (allEqual && !is) {
                if (words[i].length() < words[i - 1].length()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String[] a = {"hello", "leetcode"};
//        String b = "hlabcdefgijkmnopqrstuvwxyz";
        String[] a = {"apple","app"};
        String b = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(isAlienSorted(a, b));
    }
}
