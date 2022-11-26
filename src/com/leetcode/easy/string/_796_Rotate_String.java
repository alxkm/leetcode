package com.leetcode.easy.string;

public class _796_Rotate_String {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        s = s + s;
        return s.contains(goal);
    }
}
