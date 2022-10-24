package com.leetcode.easy.gold.array;

public class _2255_Count_Prefixes_of_a_Given_String {
    public int countPrefixes(String[] words, String s) {
        int counter = 0;
        for (String w : words) {
            if (w.length() > s.length()) continue;
            if (s.startsWith(w)) counter++;
        }
        return counter;
    }
}
