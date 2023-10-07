package com.leetcode.top;

import java.util.Stack;

public class _394_Decode_String {
    //394. Decode String
    //https://leetcode.com/problems/decode-string/
    //FOREIGN_SOLUTION
    //TOP

    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (ch == ']') {
                StringBuilder sbw = new StringBuilder();
                StringBuilder sbn = new StringBuilder();
                String str = st.pop();

                if (str.length() > 1) sbw.append(str);
                else sbw.insert(0, str.charAt(0));

                while (Character.isLetter(st.peek().charAt(0))) {
                    sbw.insert(0, st.pop());
                }
                st.pop();
                while (!st.isEmpty() && Character.isDigit(st.peek().charAt(0))) {
                    sbn.insert(0, st.pop());
                }

                StringBuilder sb = new StringBuilder(sbw);
                for (int i = 0; i < Integer.valueOf(sbn.toString()) - 1; i++) {
                    sb.append(sbw);
                }
                st.push(sb.toString());
            } else {
                st.push("" + ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }
}
