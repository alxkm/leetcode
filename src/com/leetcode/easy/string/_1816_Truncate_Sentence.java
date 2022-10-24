package com.leetcode.easy.string;

public class _1816_Truncate_Sentence {
    public String truncateSentence(String s, int k) {
        String[] a = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            sb.append(a[i]);

            if (i != k - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
