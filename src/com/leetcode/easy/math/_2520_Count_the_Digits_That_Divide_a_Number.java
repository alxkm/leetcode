package com.leetcode.easy.math;

public class _2520_Count_the_Digits_That_Divide_a_Number {
    //https://leetcode.com/problems/count-the-digits-that-divide-a-number/description/

    public int countDigits(int num) {
        int n = num;
        int counter = 0;
        while (num > 0) {
            int d = num % 10;
            num = num / 10;

            if (n % d == 0) {
                counter++;
            }
        }
        return counter;
    }
}
