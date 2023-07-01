package com.leetcode.medium.string;

import java.util.Stack;

public class _2390_Removing_Stars_From_a_String {
    //https://leetcode.com/problems/removing-stars-from-a-string/

    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (ch == '*') {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
