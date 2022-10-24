package com.leetcode.easy;

import java.util.Stack;

public class correctParentheses {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
                continue;
            }

            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (st.isEmpty()) return false;

                Character chs = st.pop();
                if (s.charAt(i) == ')' && chs.equals('(')) continue;
                if (s.charAt(i) == '}' && chs.equals('{')) continue;
                if (s.charAt(i) == ']' && chs.equals('[')) continue;

                return false;
            }
        }

        if (st.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("(]"));
    }
}
