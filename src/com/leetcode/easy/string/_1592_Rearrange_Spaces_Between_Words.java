package com.leetcode.easy.string;

public class _1592_Rearrange_Spaces_Between_Words {
    static public String reorderSpaces(String text) {
        if (text.indexOf(' ') == -1) return text;
        int cnt = (int) text.chars().filter(s -> s == ' ').count();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                sb.append(text.charAt(i));
                if (i + 1 < text.length() - 1 && text.charAt(i + 1) == ' ') {
                    sb.append(' ');
                }
            }
        }
        String[] s = sb.toString().split(" ");
        sb = new StringBuilder();
        int extra = 0;
        if (s.length > 1) {
            if (cnt % (s.length - 1) != 0) {
                extra = (cnt % (s.length - 1));
            }
            cnt = (cnt / (s.length - 1));
        } else {
            extra = cnt;
        }

        for (int i = 0; i < s.length; i++) {
            sb.append(s[i]);
            if (i != s.length - 1) {
                sb.append(" ".repeat(Math.max(0, cnt)));
            } else if (extra > 0) {
                sb.append(" ".repeat(extra));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String text1 = "  this   is  a sentence ";
        String text2 = "a";
        String text3 = "  hello";
        String text = " practice   makes   perfect";

        System.out.println(reorderSpaces(text));
    }
}
