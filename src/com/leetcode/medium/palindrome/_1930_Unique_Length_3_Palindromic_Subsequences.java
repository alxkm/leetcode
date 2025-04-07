package com.leetcode.medium.palindrome;

import java.util.HashSet;
import java.util.Set;

public class _1930_Unique_Length_3_Palindromic_Subsequences {
    //https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
    //1930. Unique Length-3 Palindromic Subsequences

    public int countPalindromicSubsequence(String s) {
        int counter = 0;

        for (int i = 0; i < 26; i++) {
            char curCh = (char) (i + 97);
            int l = s.indexOf(curCh);
            int r = s.lastIndexOf(curCh);

            if (l != -1 && r != -1 && l < r) {
                String str = s.substring(l + 1, r);
                System.out.println(str);
                Set<Character> set = new HashSet<>();
                for (char ch: str.toCharArray()) {
                    set.add(ch);
                }
                counter += set.size();
            }
        }

        return counter;
    }

    class Solution {
        public int countPalindromicSubsequence(String s) {
            boolean[][] ar = new boolean[s.length() + 1][26];
            int counter = 0;
            ar[s.length()] = new boolean[26];
            for (int i = s.length() - 1; i >= 0; i--) {
                boolean[] cur = ar[i + 1].clone();
                cur[s.charAt(i) - 'a'] = true;
                ar[i] = cur;
            }

            boolean[][] set = new boolean[26][26];
            boolean[] used = new boolean[26];
            for (int i = 0; i < s.length() - 1; i++) {
                char ch = s.charAt(i);
                if (used[ch - 'a']) continue;
                used[ch - 'a'] = true;
                for (int j = i + 1; j < s.length() - 1; j++) {
                    char ch1 = s.charAt(j);
                    if (set[ch - 'a'][ch1 - 'a']) continue;
                    set[ch - 'a'][ch1 - 'a'] = true;
                    boolean[] a = ar[j + 1];
                    if (a[ch - 'a']) counter++;
                }
            }
            return counter;
        }
    }
}
