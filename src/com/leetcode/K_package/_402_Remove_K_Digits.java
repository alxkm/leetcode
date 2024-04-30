package com.leetcode.K_package;

import java.util.Stack;

public class _402_Remove_K_Digits {
    //402. Remove K Digits
    //https://leetcode.com/problems/remove-k-digits/description/

    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for (char ch: num.toCharArray()) {
            while (k > 0 && !st.isEmpty() && st.peek() > ch) {
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while (k > 0) {
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch: st) {
            if (sb.length() == 0 && ch == '0') continue;
            sb.append(ch);
        }

        return (sb.length() == 0) ? "0" : sb.toString();
    }
}
