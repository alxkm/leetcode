package com.leetcode.easy.string.additional;

public class A {
    static public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (j < s.length() && s.charAt(j) == t.charAt(i)) {
                j++;
            }
        }
        return s.length() == j + 1;
    }

    static public boolean isPerfectSquare(int num) {
        int i = 0;
        while (i < num / 2) {
            i++;
            if (i * i == num) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String  s = "axc", t = "ahbgdc";

        //System.out.println(isSubsequence(s, t));

        System.out.println(isPerfectSquare(4));
    }
}
