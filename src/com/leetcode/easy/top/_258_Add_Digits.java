package com.leetcode.easy.top;

public class _258_Add_Digits {
    //https://leetcode.com/problems/add-digits/description/
    //258. Add Digits
    //top
    //math

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

    public int addDigits1(int num) {
        while (num >= 10) {
            int n = 0;
            while (num != 0) {
                n += num % 10;
                num /= 10;
            }
            num = n;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}
