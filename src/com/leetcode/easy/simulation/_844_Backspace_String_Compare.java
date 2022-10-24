package com.leetcode.easy.simulation;

import java.util.Stack;

public class _844_Backspace_String_Compare {
     static public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        Stack<Character> st1 = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(ch);
            }
        }

        for (char ch : t.toCharArray()) {
            if (ch == '#') {
                if (!st.isEmpty()) {
                    st1.pop();
                }
            } else {
                st1.push(ch);
            }
        }


        while (!st.isEmpty() && !st1.isEmpty()) {
            var ch = st.pop();
            var ch1 = st1.pop();

            if (ch != ch1) return false;
        }
        return (st.isEmpty() && st1.isEmpty());
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("bxj##tw",
                                            "bxj###tw"));
    }
}
