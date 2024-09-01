package com.leetcode.medium.stack;

import java.util.Stack;

public class _678_Valid_Parenthesis_String {
    //678. Valid Parenthesis String
    //https://leetcode.com/problems/valid-parenthesis-string
    //FOREIGN_SOLUTION

    public static boolean checkValidString(String s) {
        int op = 0, cl = 0, a = 0;
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                op++;
                if (!st.isEmpty()) {
                    st.push('(');
                }
            } else if (c == ')') {
                if (op + a < cl) return false;

                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(')');
                }

            } else {
                a++;
                st.push('*');
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
