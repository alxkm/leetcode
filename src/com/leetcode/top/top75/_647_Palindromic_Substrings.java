package com.leetcode.top.top75;

public class _647_Palindromic_Substrings {
    //https://leetcode.com/problems/palindromic-substrings/description/

    public int countSubstrings(String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            counter += countPalindromes(s.toCharArray(), i, i);
            counter += countPalindromes(s.toCharArray(), i, i + 1);
        }
        return counter;
    }

    private int countPalindromes(char[] chs, int l, int r) {
        int counter = 0;
        while (l >= 0 && r < chs.length && chs[l] == chs[r]) {
            counter++;
            l--;
            r++;
        }
        return counter;
    }
}
