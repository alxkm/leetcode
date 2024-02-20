package com.leetcode.easy.top.string;

import java.util.Stack;

public class _1614_Maximum_Nesting_Depth_of_the_Parentheses {
    public int maxDepth(String s) {
        int localMax = 0;
        int max = 0;
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
                max = Math.max(st.size(), max);
            } else if (s.charAt(i) == ')') {
                st.pop();
            }
        }
        return max;
    }
}
