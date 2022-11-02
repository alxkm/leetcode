package com.leetcode.medium.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
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

}
