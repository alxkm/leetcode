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
}
