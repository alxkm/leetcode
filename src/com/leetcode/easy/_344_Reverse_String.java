package com.leetcode.easy;

public class _344_Reverse_String {
    //344. Reverse String
    //https://leetcode.com/problems/reverse-string/description/

    static public void reverseString(char[] s) {
        if (s.length == 1) return;

        for (int i = 0; i < s.length / 2; i++) {
            char ch = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = ch;
        }
    }

    public void reverseString1(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e'};

        reverseString(s);

        System.out.println(s);

    }

}
