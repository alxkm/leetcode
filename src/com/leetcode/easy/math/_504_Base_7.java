package com.leetcode.easy.math;

public class _504_Base_7 {
    //504. Base 7
    //https://leetcode.com/problems/base-7/description/

    public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        boolean isNegative = num < 0;
        if (isNegative) {
            num *= -1;
        }
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        sb.reverse();
        if (isNegative) {
            sb.insert(0, '-');
        }
        return sb.toString();
    }
}
