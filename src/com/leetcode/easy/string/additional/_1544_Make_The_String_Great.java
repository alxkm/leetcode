package com.leetcode.easy.string.additional;

import java.util.Stack;

public class _1544_Make_The_String_Great {
    //1544. Make The String Great
    //https://leetcode.com/problems/make-the-string-great/description/

    static public String makeGood(String s) {
        int size = s.length();
        while (true) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                    if (i >= 1) {
                        if (((int)s.charAt(i) - 65) == ((int)s.charAt(i - 1) - 97)) {
                            String a = s.substring(0, i - 1);
                            String b = (i + 1 != s.length()) ? s.substring(i + 1) : "";
                            s = a + b;
                            break;
                        }
                    }
                    if (i + 1 < s.length()) {
                        if (((int)s.charAt(i) - 65) == ((int)s.charAt(i + 1) - 97)) {
                            String a = s.substring(0, i);
                            String b = s.substring(i + 2);
                            s = a + b;
                            break;
                        }
                    }
                }
            }
            if (size == s.length()) break;
            size = s.length();
        }
        return s;
    }

    public String makeGood1(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!st.isEmpty() && Math.abs(st.peek() - ch) == 32) {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //String s = "abBAcC";
        //String s = "leEeetcode";
        //String s = "AabBaAa";
        String s = "abv";
        System.out.println(makeGood(s));
    }
}
