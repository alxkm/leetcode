package com.leetcode.medium.hard;

public class _678_Valid_Parenthesis_String {
    //https://leetcode.com/problems/valid-parenthesis-string/
    //678. Valid Parenthesis String
    //todo

    public boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftMin++;
                leftMax++;
            } else if (ch == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }

            if (leftMax < 0) return false;
            if (leftMin < 0) leftMin = 0; //(*)(
        }
        return leftMin == 0;
    }
}
