package com.leetcode.easy.string.additional;

public class _521_Longest_Uncommon_Subsequence_I {
    static public int findLUSlength(String a, String b) {
        int counter = 0;
        if (a.length() > b.length()) {
            return a.length();
        } else if (a.length() < b.length()) {
            return b.length();
        } else if (!a.equals(b)) {
            return a.length();
        }
        return -1;
    }

    public static void main(String[] args) {
//        String s = "aefawfawfawfaw";
//        String s1 = "aefawfeawfwafwaef";

        String s =  "aefawfawfawfaw";
        String s1 = "aefawfeawfwafwaef";

        System.out.println(findLUSlength(s, s1));
    }
}
