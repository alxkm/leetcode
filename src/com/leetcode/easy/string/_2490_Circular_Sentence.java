package com.leetcode.easy.string;

public class _2490_Circular_Sentence {
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
}
