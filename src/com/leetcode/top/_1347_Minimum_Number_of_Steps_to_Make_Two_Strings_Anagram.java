package com.leetcode.top;

import java.util.HashMap;
import java.util.Map;

public class _1347_Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram {
    //1347. Minimum Number of Steps to Make Two Strings Anagram
    //https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/

    public int minSteps(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch: t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int size = 0;

        for (char ch: s.toCharArray()) {
            var num = map.get(ch);

            if (num == null || num == 0) {
                size++;
            } else {
                map.put(ch, num - 1);
            }
        }

        return size;
    }
}
