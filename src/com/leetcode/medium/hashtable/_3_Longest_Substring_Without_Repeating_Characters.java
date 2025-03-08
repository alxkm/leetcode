package com.leetcode.medium.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _3_Longest_Substring_Without_Repeating_Characters {
    //3. Longest Substring Without Repeating Characters
    //https://leetcode.com/problems/longest-substring-without-repeating-characters/

    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxSize = 0;
        if (s.equals("")) return maxSize;

        for (int i = 0; i < s.length(); i++) {

            Integer index = map.get(s.charAt(i));
            if (index == null) {
                map.put(s.charAt(i), i);
                maxSize = Math.max(maxSize, map.size());
                continue;
            }
            map.put(s.charAt(i), i);

            Set<Character> keys = new HashSet<>();
            for (Map.Entry<Character, Integer> kv : map.entrySet()) {
                if (kv.getValue() < index) {
                    keys.add(kv.getKey());
                }
            }
            for (Character key : keys) {
                map.remove(key);
            }
        }
        return maxSize;
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int globalMax = 0;
        Map<Character, Integer> map = new HashMap<>();
        int started = 0;
        char[] ar = s.toCharArray();
        for (int i = 0; i < ar.length; i++) {
            if (map.get(ar[i]) != null) {
                int prev = map.get(ar[i]);
                for (int j = started; j < prev; j++) map.remove(ar[j]);
                started = prev + 1;
                map.put(ar[i], i);
                max = map.size();
            } else {
                map.put(ar[i], i);
                max++;
            }
            globalMax = Math.max(max, globalMax);
        }
        return globalMax;
    }
    public static int lengthOfLongestSubstring2(String s) {
        char[] ch = s.toCharArray();
        int max = 1;
        Set<Character> set = new HashSet<>();
        for (int i = 0, j = 0; i < ch.length && i < ch.length;) {
            while (j < ch.length && set.add(ch[j])) {
                max = Math.max(j - i + 1, max);
                j++;
            }
            System.out.println("j = " + j);
            while (i < ch.length && j < ch.length) {
                set.remove(ch[i]);
                char prev = ch[i];
                i++;
                if (prev == ch[j]) break;

            }
            System.out.println("i = " + i);
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
    }
}
