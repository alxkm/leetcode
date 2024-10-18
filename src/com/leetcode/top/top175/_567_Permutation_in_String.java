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

    public boolean checkInclusion1(String s1, String s2) {
        int[] ch1 = new int[26];
        int[] ch2 = new int[26];
        for (char ch: s1.toCharArray()) {
            ch1[ch - 'a']++;
        }
        for (char ch: s2.toCharArray()) {
            ch2[ch - 'a']++;
        }
        char[] s = s2.toCharArray();
        for (int i = 0; i < s.length; i++) {
            int ch = s[i] - 'a';
            if (ch1[ch] != 0) {
                int[] copy = new int[26];
                System.arraycopy(ch1, 0, copy, 0, 26);
                int sum = s1.length();
                for (int j = i; j < s.length && sum > 0; j++) {
                    int c = s2.charAt(j) - 'a';
                    //case when it is not exist in s1
                    if (ch1[c] == 0 && ch2[c] != 0) {
                        i = j;
                        break;
                    }
                    //case when we already filled all but it still exist
                    if (ch1[c] > 0 && copy[c] == 0) {
                        break;
                    }
                    //
                    if (ch1[c] > 0 && copy[c] > 0) {
                        copy[c]--;
                        sum--;
                    }
                }
                boolean contains = true;
                for (int n: copy) if (n != 0) contains = false;
                if (contains) return true;
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
