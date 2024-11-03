package com.leetcode.easy.string;

public class _796_Rotate_String {
    //796. Rotate String
    //https://leetcode.com/problems/rotate-string

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        s = s + s;
        return s.contains(goal);
    }

    public boolean rotateString1(String s, String goal) {
        String str = s + s;
        return s.length() <= goal.length() && str.contains(goal);
    }
}
