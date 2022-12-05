package com.leetcode.easy.math;

public class _171_Excel_Sheet_Column_Number {
    static public int titleToNumber(String columnTitle) {
        int result = 0;
        char[] ch = columnTitle.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            result += (ch[i] - 65 + 1) * Math.pow((ch.length - i), (ch.length  - i - 1));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AZ"));
    }
}
