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

    public static int minSteps1(String s, String t) {
        int[] s1 = new int[26];
        int[] s2 = new int[26];
        for (char ch: s.toCharArray()) s1[ch - 'a']++;
        for (char ch: t.toCharArray()) s2[ch - 'a']++;

        int min1 = 0, min2 = 0;

        for (int i = 0; i < 26; i++) {
            if (s1[i] != 0) {
                if (s1[i] >= s2[i])
                    min1 += Math.abs(s1[i] - s2[i]);
            }
            if (s2[i] != 0) {
                if (s2[i] >= s1[i])
                    min2 += Math.abs(s2[i] - s1[i]);
            }
        }
        return Math.min(min1, min2);
    }

    public static void main(String[] args) {
        System.out.println(minSteps1("leetcode", "practice"));
    }
}
