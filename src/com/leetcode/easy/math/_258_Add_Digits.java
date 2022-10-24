package com.leetcode.easy.math;

public class _258_Add_Digits {
    static public int addDigits(int num) {
        while (num / 10 != 0) {
            int d = num / 10;
            int sum = 0;
            sum += num % 10;
            while (d != 0) {
                sum += d % 10;
                d /= 10;
            }
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}
