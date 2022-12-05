package com.leetcode.easy.math;

public class _168_Excel_Sheet_Column_Title {
    public static String convertToTitle(int columnNumber) {
        StringBuilder title = new StringBuilder();
        int n = columnNumber;
        while (n > 0) {
            if (n <= 26) {
                title.append((char) (65 + n - 1));
                n = 0;
            } else {
                int r = n % 26;
                n /= 26;
                if (r == 0) {
                    title.append('Z');
                } else {
                    title.append((char) ('A' + r - 1));
                }
            }
        }
        title.reverse();
        return title.toString();
    }

    public static void main(String[] args) {
        int a = 102102;
        System.out.println(convertToTitle(a));
    }
}
