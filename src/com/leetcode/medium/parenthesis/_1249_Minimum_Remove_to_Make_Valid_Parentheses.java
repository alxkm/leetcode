package com.leetcode.medium.parenthesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _1249_Minimum_Remove_to_Make_Valid_Parentheses {
    //https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
    //1249. Minimum Remove to Make Valid Parentheses

    public String minRemoveToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] chs = s.toCharArray();
        int op = 0;
        int cl = 0;
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if (Character.isAlphabetic(ch)) {
                st.add(ch);
                continue;
            }
            if (ch == '(') {
                st.add(ch);
                op++;
                continue;
            }
            if (ch == ')') {
                if (op >= cl + 1) {
                    st.add(ch);
                    cl++;
                }
                continue;
            }
        }

        if (op != cl) {
            List<Character> l = new ArrayList<>();
            while (op != cl) {
                char ch = st.pop();
                if (ch == '(') {
                    op--;
                    continue;
                } else {
                    l.add(ch);
                }
            }

            for (int i = l.size() - 1; i >= 0; i--) {
                st.add(l.get(i));
            }
        }

        List<Character> list = new ArrayList<>();
        list.addAll(st);

        StringBuilder sb = new StringBuilder();
        for (Character ch: list) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public String minRemoveToMakeValid1(String s) {
        Stack<Character> stack = new Stack<>();
        int op = 0;
        for (char ch: s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
                op++;
            }
            else if (ch == ')') {
                if (op > 0) {
                    op--;
                    stack.push(')');
                }
            } else {
                stack.push(ch);
            }
        }
        StringBuilder tail = new StringBuilder();
        if (op > 0) {
            List<Character> l = new ArrayList<>();
            while (op > 0) {
                char ch = stack.pop();
                if (ch == '(') {
                    op--;
                } else {
                    tail.insert(0, ch);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch: stack) {
            sb.append(ch);
        }
        sb.append(tail);
        return sb.toString();
    }
}
