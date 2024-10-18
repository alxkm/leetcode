package com.leetcode.medium.string;

public class _1813_Sentence_Similarity_III {
    //1813. Sentence Similarity III
    //https://leetcode.com/problems/sentence-similarity-iii/description/

    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) return true;
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        int pref = -1;
        for (int i = 0; i < s1.length && i < s2.length; i++) {
            if (!s1[i].equals(s2[i])) break;
            pref = i;
        }

        if (s1.length - 1 == pref || s2.length - 1 == pref) return true;

        int counter = 0;
        for (int i = s1.length - 1, j = s2.length - 1; i > pref && j > pref; i--, j--) {
            if (!s1[i].equals(s2[j])) break;
            counter++;
        }

        if (pref + counter + 1 == s1.length || pref + counter + 1 == s2.length) return true;

        return false;
    }
}
