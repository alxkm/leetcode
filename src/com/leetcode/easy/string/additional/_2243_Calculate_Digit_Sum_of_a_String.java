package com.leetcode.easy.string.additional;

public class _2243_Calculate_Digit_Sum_of_a_String {
    static     public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i += k) {
                int sum = 0;
                for (int j = i; j < s.length() && j < i + k; j++) {
                    sum += ((int)s.charAt(j) - 48);
                }
                sb.append(sum);
            }

            s = sb.toString();
            System.out.println(s);
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(digitSum("01234567890", 2));
    }
}
