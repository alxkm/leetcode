package com.leetcode.top.top175;

import java.util.HashMap;
import java.util.Map;

public class _567_Permutation_in_String {
    //567. Permutation in String
    //https://leetcode.com/problems/permutation-in-string/description/

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> sizeMap = new HashMap<>();
        for (char ch: s1.toCharArray()) {
            sizeMap.put(ch, sizeMap.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (sizeMap.keySet().contains(ch)) {
                int j = i;
                Map<Character, Integer> map = new HashMap<>(sizeMap);
                while (!map.isEmpty() && j < s2.length()) {
                    char curChar = s2.charAt(j);
                    var curSize = map.get(curChar);
                    if (curSize == null || curSize == 0) {
                        i = j;
                        break;
                    }
                    if (curSize - 1 == 0) {
                        map.remove(curChar);
                    } else {
                        map.put(curChar, curSize - 1);
                    }
                    j++;
                }
                if (map.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char ch = ' ';
        //String s1 = "ab", s2 = "eidbaooo";
        String s1 = "adc", s2 = "dcda";
        var solution = new _567_Permutation_in_String();
        System.out.println(solution.checkInclusion(s1, s2));
    }
}
