package com.leetcode.medium.math;

public class _1400_Construct_K_Palindrome_Strings {
    //1400. Construct K Palindrome Strings
    //https://leetcode.com/problems/construct-k-palindrome-strings/description/

    public boolean canConstruct(String s, int k) {
        int[] ch = new int[26];
        for (char c: s.toCharArray()) {
            ch[c - 'a']++;
        }
        int sn = 0;
        int d = 0;
        for (int n: ch) {
            d += n / 2;
            sn += n % 2;
        }
        return sn <= k && s.length() >= k;
    }
}
