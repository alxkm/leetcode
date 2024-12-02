package com.leetcode.easy.string;

public class _1455_Check_If_a_Word_Occurs_As_a_Prefix_of_Any_Word_in_a_Sentence {
    //1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence
    //https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/description/

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] str = sentence.split(" ");
        int i = 0;
        for (String s: str) {
            i++;
            if (s.startsWith(searchWord)) return i;
        }
        return -1;
    }

    class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            String[] s = sentence.split(" ");
            for (int i = 0; i < s.length; i++) {
                if (s[i].startsWith(searchWord)) {
                    return i + 1;
                }
            }
            return -1;
        }
    }
}
