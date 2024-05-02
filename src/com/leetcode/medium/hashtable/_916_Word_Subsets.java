package com.leetcode.medium.hashtable;

import java.util.ArrayList;
import java.util.List;

public class _916_Word_Subsets {
    //916. Word Subsets
    //https://leetcode.com/problems/word-subsets/description/

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> l = new ArrayList<>();
        int[] max = new int[26];
        for (String s : words2) {
            int[] curCounter = new int[26];
            for (char c : s.toCharArray()) {
                int i = (c - 'a');
                max[i] = Math.max(++curCounter[i], max[i]);
            }
        }

        for (String value : words1) {
            int[] curCounter = new int[26];
            for (char c : value.toCharArray()) {
                curCounter[c - 'a']++;
            }

            boolean includesAll = true;
            for (int i = 0; i < curCounter.length; i++) {
                if (curCounter[i] < max[i]) {
                    includesAll = false;
                    break;
                }
            }
            if (includesAll) l.add(value);
        }
        return l;
    }
}
