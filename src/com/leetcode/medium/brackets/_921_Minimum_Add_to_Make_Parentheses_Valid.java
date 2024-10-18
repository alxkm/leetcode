package com.leetcode.medium.brackets;

import java.util.Stack;

public class _921_Minimum_Add_to_Make_Parentheses_Valid {
    //921. Minimum Add to Make Parentheses Valid
    //https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/

    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int c = 0;
        for (char ch: s.toCharArray()) {
            if (ch == '(') {
                st.push('(');
            } else {
                if (st.size() == 0) {
                    c++;
                } else {
                    if (st.peek() == '(') {
                        st.pop();
                    } else {
                        c++;
                    }
                }
            }
        }

        return c + st.size();
    }
}
