package com.leetcode.medium.stack;

import java.util.Stack;

public class _1190_Reverse_Substrings_Between_Each_Pair_of_Parentheses {
    //1190. Reverse Substrings Between Each Pair of Parentheses
    //https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/?envType=daily-question&envId=2024-07-11

    public String reverseParentheses(String s) {
        Stack<StringBuilder> st = new Stack<StringBuilder>();

        for (char ch: s.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                if (st.isEmpty()) st.push(new StringBuilder());
                st.peek().append(ch);
            } else if (ch == '(') {
                st.add(new StringBuilder());
            } else if(ch == ')') {
                StringBuilder sb = st.pop();
                sb.reverse();
                if (st.isEmpty()) st.push(sb);
                else st.peek().append(sb);
            }
        }
        return st.pop().toString();
    }
}
