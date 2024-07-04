package com.leetcode.easy.string;

public class _2068_Check_Whether_Two_Strings_are_Almost_Equivalent {
    //https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/description/
    //2068. Check Whether Two Strings are Almost Equivalent

    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] w1 = new int[26];
        int[] w2 = new int[26];

        for (char ch : word1.toCharArray()) {
            w1[ch - 'a']++;
        }
        for (char ch : word2.toCharArray()) {
            w2[ch - 'a']++;
        }

        for (int i = 0; i < w1.length; i++) {
            if (Math.abs(w1[i] - w2[i]) >= 4) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new _2068_Check_Whether_Two_Strings_are_Almost_Equivalent();
        System.out.println(sol.checkAlmostEquivalent("abcdeef", "abaaacc"));
    }
}
