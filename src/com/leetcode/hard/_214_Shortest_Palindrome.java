package com.leetcode.hard;

public class _214_Shortest_Palindrome {
    //214. Shortest Palindrome
    //https://leetcode.com/problems/shortest-palindrome/description/?envType=daily-question&envId=2024-09-20
    //Roling hash
    //NOT_MAIN
    //ALMOST
    //TODO TODO TODO

    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();

        // Find the longest palindromic prefix by comparing original and reversed strings
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(0, s.length() - i).equals(rev.substring(i))) {
                // Add the unmatched part of the reversed string to the front
                return rev.substring(0, i) + s;
            }
        }

        return "";
    }

    public String shortestPalindrome1(String s) {
        // Reverse the string
        String rev = new StringBuilder(s).reverse().toString();

        // Concatenate the original and reversed strings with a separator
        String combined = s + "#" + rev;

        // Build the KMP table (Longest Prefix which is also Suffix)
        int[] lps = buildKMPTable(combined);

        // Length of the longest palindromic prefix
        int palLength = lps[lps.length - 1];

        // Add the remaining characters from the reverse to the front
        return rev.substring(0, s.length() - palLength) + s;
    }

    private int[] buildKMPTable(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0, i = 1;

        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    class Solution {
        public String shortestPalindrome(String s) {
            if (s.equals("") || s.length() == 1 || isPal(s, s.length() - 1)) return s;
            int end = 0;
            for (int i = 0; i < s.length(); i++) {
                if (isPal(s, i)) {
                    end = i;
                }
            }
            if (end != s.length() - 1) end++;
            StringBuilder sb = new StringBuilder(s.substring(end));
            sb.reverse();
            return sb.toString() + s;
        }

        boolean isPal(String str, int end) {
            int len = end + 1;
            for (int i = 0; i < len / 2; i++) {
                if (str.charAt(i) != str.charAt(len - i - 1))
                    return false;
            }
            return true;
        }
    }
}
