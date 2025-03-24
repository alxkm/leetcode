package com.leetcode.easy.string;

public class _2185_Counting_Words_With_a_Given_Prefix {
    //2185. Counting Words With a Given Prefix
    //https://leetcode.com/problems/counting-words-with-a-given-prefix/description/

    public int prefixCount(String[] words, String pref) {
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(pref)) {
                counter++;
            }
        }
        return counter;
    }

    public int prefixCount1(String[] words, String pref) {
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= pref.length() && words[i].startsWith(pref)) counter++;
        }
        return counter;
    }
}
