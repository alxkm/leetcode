package com.leetcode.easy.string;

public class _2490_Circular_Sentence {
    //2490. Circular Sentence
    //https://leetcode.com/problems/circular-sentence/

    public boolean isCircularSentence(String sentence) {
        String[] a = sentence.split(" ");
        int j = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[i].charAt(0) != a[j].charAt(a[j].length() - 1)) return false;
            j = i;
        }

        return a[j].charAt(a[j].length() - 1) == a[0].charAt(0);
    }

    public boolean isCircularSentence1(String sentence) {
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) return false;
        String[] words = sentence.split(" ");
        char prev = words[0].charAt(words[0].length() - 1);
        for (int i = 1; i < words.length; i++) {
            if (words[i].charAt(0) != prev) return false;
            prev = words[i].charAt(words[i].length() - 1);
        }
        return true;
    }
}
