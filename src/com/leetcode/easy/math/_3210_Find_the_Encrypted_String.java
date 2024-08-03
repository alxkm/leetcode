package com.leetcode.easy.math;

public class _3210_Find_the_Encrypted_String {
    //3210. Find the Encrypted String
    //https://leetcode.com/problems/find-the-encrypted-string/

    public String getEncryptedString(String s, int k) {
        char[] s1 = new char[s.length() * 2];
        for (int i = 0, j = s.length(); i < s.length(); i++, j++) {
            s1[i] = s.charAt(i);
            s1[j] = s.charAt(i);
        }

        char[] ch = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            int j = k % s.length();
            j += i;
            ch[i] = s1[j];
        }

        return String.valueOf(ch);
    }
}
