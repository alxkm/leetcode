package com.leetcode.easy.string;

public class _2810_Faulty_Keyboard {
    //2810. Faulty Keyboard
    //https://leetcode.com/problems/faulty-keyboard/description/

    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch: s.toCharArray()) {
            if (ch == 'i') {
                sb.reverse();
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
