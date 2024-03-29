package com.leetcode.easy.string.additional;

public class _2264_Largest_3_Same_Digit_Number_in_String {
    //2264. Largest 3-Same-Digit Number in String
    //https://leetcode.com/problems/largest-3-same-digit-number-in-string/

    static public String largestGoodInteger(String num) {
        if (num.length() < 3) return "";
        if (num.length() == 3 && num.charAt(0) == num.charAt(1) && num.charAt(1) == num.charAt(2)) {
            return String.valueOf(num.charAt(0)).repeat(3);
        } else if (num.length() == 3) {
            return "";
        }
        int digit = -1;
        for (int i = 0; i <= num.length() - 3;) {
            if (num.charAt(i) == num.charAt(i + 1)
                    && num.charAt(i + 1) == num.charAt(i + 2)) {
                int temp = (int) num.charAt(i) - 48;
                if (temp > digit) digit = temp;
                i += 3;
            } else {
                i += 1;
            }
        }

        if (digit == -1) {
            return "";
        } else {
            return String.valueOf(digit).repeat(3);
        }
    }

    public String largestGoodInteger1(String num) {
        String s = "";
        char[] ch = num.toCharArray();
        for (int i = 0; i <= num.length() - 3; i++) {
            if (ch[i] != ch[i + 1]) continue;
            if (ch[i + 1] != ch[i + 2]) continue;

            if (s.equals("") || (s.charAt(0) < ch[i])) {
                s = num.substring(i, i + 3);
                i += 2;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        //String s = "6777133339";
        String s = "1221000";

        System.out.println(largestGoodInteger(s));
    }
}
