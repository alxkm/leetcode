package com.leetcode.easy.string.additional;

public class _1332_Remove_Palindromic_Subsequences {
    static public int removePalindromeSub(String s) {
        int a = 0;
        int b = 0;
        boolean is = true;

        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            if (s.charAt(i) == 'a') a++;
            if (s.charAt(i) == 'b') b++;

            if (i < j && s.charAt(i) != s.charAt(j)) is = false;
        }
        if (is) return 1;
        return Math.abs(a - b);
    }

    public static void main(String[] args) {

    }
}
