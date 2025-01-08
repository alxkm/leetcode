package com.leetcode.easy.prefix;

public class _3042_Count_Prefix_and_Suffix_Pairs_I {
    //3042. Count Prefix and Suffix Pairs I
    //https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/

    public int countPrefixSuffixPairs(String[] words) {
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public int countPrefixSuffixPairs1(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].length() < words[i].length()) continue;
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) count++;
            }
        }
        return count;
    }
}
