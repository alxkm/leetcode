package com.leetcode.medium.sort;

import java.util.Arrays;

public class _1451_Rearrange_Words_in_a_Sentence {
    //https://leetcode.com/problems/rearrange-words-in-a-sentence/description/
    //1451. Rearrange Words in a Sentence

    record StrPair(String s, int i) {}

    public String arrangeWords(String text) {
        String[] strs = text.split(" ");
        StrPair[] s = new StrPair[strs.length];

        for (int i = 0; i < strs.length; i++) {
            s[i] = new StrPair(strs[i], i);
        }

        Arrays.sort(s, (x, y) -> {
            if (x.s.length() == y.s.length()) return x.i - y.i;
            return x.s.length() - y.s.length();
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length; i++) {
            char[] str = s[i].s.toCharArray();

            if (i == 0) {
                str[0] = Character.toUpperCase(str[0]);
            } else {
                str[0] = Character.toLowerCase(str[0]);
            }

            sb.append(new String(str));
            if (i != s.length - 1) sb.append(" ");
        }

        return sb.toString();
    }
}
