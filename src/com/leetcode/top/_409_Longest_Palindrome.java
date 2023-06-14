package com.leetcode.top;

public class _409_Longest_Palindrome {
    //409. Longest Palindrome
    //https://leetcode.com/problems/longest-palindrome/

    public int longestPalindrome(String s) {
        int[] map = new int[128];
        for (char ch: s.toCharArray()) map[ch]++;
        int total = 0;
        int odd = 0;
        for (int i: map) {
            if (i != 0) {
                if (i % 2 == 0) {
                    total += i;
                } else {
                    total += i - 1;
                    odd++;
                }
            }
        }
        return total + (odd > 0 ? 1 : 0);
    }
}
