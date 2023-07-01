package com.leetcode.medium.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _151_Reverse_Words_in_a_String {
    //https://leetcode.com/problems/reverse-words-in-a-string/
    //todo todo

    public String reverseWords(String s) {
        s.trim();
        String[] stringArray = s.split(" ");
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i].trim();
            StringBuilder temp = new StringBuilder();
            char[] w = stringArray[i].toCharArray();
            for (int j = 0; j < w.length; j++) {
                if (Character.isLetter(w[j]) || Character.isDigit(w[j])) {
                    temp.append(w[j]);
                }
            }
            if (!temp.toString().equals("")) {
                strings.add(temp.toString());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = strings.size() - 1; i >= 0; i--) {
            sb.append(strings.get(i));
            if (i != 0) sb.append(" ");
        }
        return sb.toString();
    }

    public String reverseWords1(String s) {
        Stack<String> stack = new Stack<>();
        String[] ar = s.split(" ");
        for (String str: ar) {
            StringBuilder sb = new StringBuilder();
            for (char ch: str.toCharArray()) {
                if (ch != ' ') sb.append(ch);
            }
            if (!sb.toString().equals("")) {
                stack.add(sb.toString());
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 1) {
            sb.append(stack.pop()).append(" ");
        }
        sb.append(stack.pop());
        return sb.toString();
    }
}
