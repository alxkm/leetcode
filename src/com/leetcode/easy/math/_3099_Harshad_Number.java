package com.leetcode.easy.math;

public class _3099_Harshad_Number {
    //3099. Harshad Number
    //https://leetcode.com/problems/harshad-number/description/

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int n = x;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return (x % sum == 0) ? sum : -1;
    }
}
