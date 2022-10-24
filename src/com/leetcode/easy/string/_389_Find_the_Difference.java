package com.company.string;

public class _389_Find_the_Difference {
    static public char findTheDifference(String s, String t) {
        int l1 = 0, l2 = 0;
        for (int i = 0; i < t.length(); i++) {
            if (i < s.length()) l1 += s.charAt(i);
            l2 += (int)t.charAt(i);
        }
        return (char)(l2 - l1);
    }

    public static void main(String[] args) {
        String s = "abcd", t = "abcde";

        System.out.println(findTheDifference(s, t));
    }
}
