package com.leetcode.easy.bit;

public class _2864_Maximum_Odd_Binary_Number {
    //https://leetcode.com/problems/maximum-odd-binary-number/
    //2864. Maximum Odd Binary Number

    public String maximumOddBinaryNumber(String s) {
        int ones = 0;
        int zeros = 0;
        for (char ch: s.toCharArray()) {
            if (ch == '1') ones++;
            else zeros++;
        }
        StringBuilder sb = new StringBuilder();
        if (ones-- > 0) sb.append('1');
        while (zeros-- > 0) sb.append('0');
        while (ones-- > 0) sb.append('1');
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        var sol = new _2864_Maximum_Odd_Binary_Number();
        System.out.println(sol.maximumOddBinaryNumber("010"));
    }
}
