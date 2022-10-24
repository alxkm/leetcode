package com.leetcode.easy.string.additional;

public class _541_Reverse_String_II {
    static public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        boolean skip = false;
        StringBuilder tsb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (skip) {
                sb.append(ch);
                i++;
                if (i == k) {
                    skip = false;
                    i = 0;
                }
            } else if (!skip) {
                tsb.append(ch);
                i++;
                if (i == k) {
                    skip = false;
                    i = 0;
                    tsb.reverse();
                    sb.append(tsb);
                    tsb = new StringBuilder();
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(str, k));

    }
}
