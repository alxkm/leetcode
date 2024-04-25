package com.leetcode.medium.parenthesis;

import java.util.Stack;

public class _2116_Check_if_a_Parentheses_String_Can_Be_Valid {
    //2116. Check if a Parentheses String Can Be Valid
    //https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/

    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false;
        Stack<Integer> open = new Stack<>();
        Stack<Integer> free = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (locked.charAt(i) == '0') {
                free.push(i);
            } else {
                if (ch == '(') {
                    open.push(i);
                } else {
                    if (!open.isEmpty()) {
                        open.pop();
                    } else if (!free.isEmpty()) {
                        free.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        while(!open.isEmpty()) {
            if (free.isEmpty() || open.peek() > free.peek()) return false;
            open.pop();
            free.pop();
        }

        if (free.size() % 2 != 0) return false;

        return true;
    }

}
