package com.leetcode.medium.string;

public class _3271_Hash_Divided_String {
    //3271. Hash Divided String
    //https://leetcode.com/problems/hash-divided-string/description/

    public String stringHash(String s, int k) {
        StringBuilder result = new StringBuilder();
        for (int i = 0, cur = 0, hashedChar = 0; i <= s.length(); i++) {
            if (i < s.length()) {
                hashedChar += (int)(s.charAt(i) - 'a');
            }
            if (cur == k - 1 || i == s.length()) {
                hashedChar %= 26;
                result.append((char)('a' + hashedChar));
                cur = 0;
                hashedChar = 0;
                if (i + 1 == s.length()) break;
            } else {
                cur++;
            }
        }
        return result.toString();
    }
}
