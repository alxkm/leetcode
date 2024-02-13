package com.leetcode.easy.string;

public class _2108_Find_First_Palindromic_String_in_the_Array {
    //2108. Find First Palindromic String in the Array
    //https://leetcode.com/problems/find-first-palindromic-string-in-the-array/

    public String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            sb.reverse();
            if (words[i].equals(sb.toString())) {
                return words[i];
            }
        }
        return "";
    }

    public String firstPalindrome1(String[] words) {
        for (String w: words) {
            int i = 0, j = w.length() - 1;
            while (i < j && i < w.length() && w.charAt(i) == w.charAt(j)) {
                i++;
                j--;
            }
            if (i == j || i > j) return w;
        }
        return "";
    }
}
