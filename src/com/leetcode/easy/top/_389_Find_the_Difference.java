package com.leetcode.easy.top;

public class _389_Find_the_Difference {
    //https://leetcode.com/problems/find-the-difference/
    //389. Find the Difference
    //string
    //easyTop

    static public char findTheDifference(String s, String t) {
        int l1 = 0, l2 = 0;
        for (int i = 0; i < t.length(); i++) {
            if (i < s.length()) l1 += s.charAt(i);
            l2 += (int)t.charAt(i);
        }
        return (char)(l2 - l1);
    }

    public char findTheDifference1(String s, String t) {
        int n = 0;
        for (int i = 0; i < Math.max(s.length(), t.length()); i++) {
            if (i < s.length()) {
                n = n ^ s.charAt(i);
            }
            if (i < t.length()) {
                n = n ^ t.charAt(i);
            }
        }
        return (char)n;
    }

    public static void main(String[] args) {
        String s = "abcd", t = "abcde";

        System.out.println(findTheDifference(s, t));
    }
}
