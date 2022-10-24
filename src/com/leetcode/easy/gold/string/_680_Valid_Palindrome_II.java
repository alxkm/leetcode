package com.company.gold.string;

public class _680_Valid_Palindrome_II {
    static public boolean validPalindrome(String s) {
        if (s.length() == 2) return true;
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(r) != s.charAt(l)) {
                return isPalindrome(s.substring(0, l) + s.substring(l + 1)) || isPalindrome(s.substring(0, r) + s.substring(r + 1));
            }
            l++;
            r--;
        }
        return true;
    }

    static private boolean isPalindrome(String s) {
        int m = s.length() % 2 == 0 ? s.length() / 2 : (s.length() - 1) / 2;
        for (int i = 0, j = s.length() - 1; i <= m; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abca";
        String s1 = "abc";
        String s2 = "bddb";

        System.out.println(validPalindrome(s2));
    }
}
