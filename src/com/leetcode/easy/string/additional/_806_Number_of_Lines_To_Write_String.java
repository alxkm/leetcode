package com.leetcode.easy.string.additional;

import java.util.Arrays;

public class _806_Number_of_Lines_To_Write_String {
    static public int[] numberOfLines(int[] widths, String s) {
        int lines = 0;
        int sum = 0;
        int prevSum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            int a = widths[ch - 97];
            if (sum + a < 100) {
                sum += a;
                prevSum = sum;
                continue;
            }
            if (sum + a == 100) {
                sum = 0;
                prevSum = 100;
                lines++;
                continue;
            }
            lines++;
            sum = a;
            prevSum = sum;
        }
        if (sum > 0) lines++;

        return new int[]{lines, prevSum};
    }

    public static void main(String[] args) {
        int[] a = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(Arrays.toString(numberOfLines(a, s)));
    }
}
