package com.leetcode.medium.bitmask;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _1371_Find_the_Longest_Substring_Containing_Vowels_in_Even_Counts {
    //1371. Find the Longest Substring Containing Vowels in Even Counts
    //https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/description/

    //TLE
    public int findTheLongestSubstring0(String s) {
        Set<Character> vowels = Set.of( 'a', 'e', 'i', 'o', 'u');
        Map<Character, Integer> mapVowels = new HashMap<>();
        for (var ch: vowels) {
            mapVowels.put(ch, 0);
        }
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> map = new HashMap<>(mapVowels);
            for (int j = i; j < s.length(); j++) {
                if (vowels.contains(s.charAt(j))) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                }
                boolean isEven = true;
                for (int v: map.values()) {
                    if (v % 2 != 0) {
                        isEven = false;
                        break;
                    }
                }
                if (isEven) max = Math.max(max, j - i + 1);
            }
        }

        return max;
    }

    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0;
        int mask = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'a') {
                mask ^= (1 << 0);
            } else if (c == 'e') {
                mask ^= (2 << 1);
            } else if (c == 'i') {
                mask ^= (3 << 2);
            } else if (c == 'o') {
                mask ^= (4 << 3);
            } else if (c == 'u') {
                mask ^= (5 << 4);
            }

            if (map.containsKey(mask)) {
                maxLength = Math.max(maxLength, i - map.get(mask));
            } else {
                map.put(mask, i);
            }
        }

        return maxLength;
    }
}
