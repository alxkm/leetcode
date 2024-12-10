package com.leetcode.hard;

import java.util.Stack;

public class _1106_Parsing_A_Boolean_Expression {
    //1106. Parsing A Boolean Expression
    //https://leetcode.com/problems/parsing-a-boolean-expression/description/

    public boolean parseBoolExpr(String expression) {
        Stack<Character> ops = new Stack<>();
        Stack<Boolean> st = new Stack<>();
        int n = expression.length();
        char[] s = expression.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = s[i];
            if (c == '&' || c == '!' || c == '|') {
                ops.push(c);
                st.push(null);
                i++;
            } else if (c == 'f') {
                st.push(false);
            } else if(c == 't') {
                st.push(true);
            } else if (c == ')') {
                boolean val = st.pop();
                char op = ops.pop();
                if (op == '!') {
                    val = !val;
                } else {
                    while (st.peek() != null) {
                        boolean b = st.pop();
                        if (op == '|') val = val || b;
                        else if (op == '&') val = val && b;
                    }
                }
                st.pop();
                st.push(val);
            }
        }
        return st.pop();
    }
}
