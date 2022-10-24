package com.leetcode.easy.string.additional;

public class _1903_Largest_Odd_Number_in_String {
    static public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            int temp = (int) num.charAt(i) - 48;
            if (temp % 2 == 0) continue;
            return num.substring(0, i + 1);
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "52";
        String s1 = "35427";
        System.out.println(largestOddNumber(s1));
    }
}
