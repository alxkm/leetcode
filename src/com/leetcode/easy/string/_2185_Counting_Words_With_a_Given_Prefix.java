package com.leetcode.easy.string;

public class _2185_Counting_Words_With_a_Given_Prefix {
    public int prefixCount(String[] words, String pref) {
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(pref)) {
                counter++;
            }
        }
        return counter;
    }
}
