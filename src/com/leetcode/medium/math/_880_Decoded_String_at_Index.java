package com.leetcode.medium.math;

public class _880_Decoded_String_at_Index {
    //880. Decoded String at Index
    //https://leetcode.com/problems/decoded-string-at-index/

    public String decodeAtIndex(String s, int k) {
        long length = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                length *= (ch - '0');
            } else {
                length++;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                length /= (ch - '0');
                k %= length;
            } else {
                if (k == 0 || k == length) {
                    return String.valueOf(ch);
                }
                length--;
            }
        }
        return "";
    }
}
