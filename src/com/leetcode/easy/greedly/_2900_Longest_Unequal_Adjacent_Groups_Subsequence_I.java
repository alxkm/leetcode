package com.leetcode.easy.greedly;

import java.util.ArrayList;
import java.util.List;

public class _2900_Longest_Unequal_Adjacent_Groups_Subsequence_I {
    //2900. Longest Unequal Adjacent Groups Subsequence I
    //https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> l = new ArrayList<>();
        l.add(words[0]);
        int prev = groups[0];

        for (int i = 1; i < words.length; i++) {
            if (groups[i] != prev) {
                l.add(words[i]);
                prev = groups[i];
            }
        }

        return l;
    }
}
