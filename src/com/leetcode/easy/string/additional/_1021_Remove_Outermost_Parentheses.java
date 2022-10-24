package com.leetcode.easy.string.additional;

public class _1021_Remove_Outermost_Parentheses {
    static public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        int closed = 0;
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open++;
            } else {
                closed++;
            }
            if (open > 0 && open == closed) {
                sb.append(s, last + 1, i);
                last = i + 1;
                open = 0;
                closed = 0;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "()()";

        System.out.println(removeOuterParentheses(s));
    }
}
