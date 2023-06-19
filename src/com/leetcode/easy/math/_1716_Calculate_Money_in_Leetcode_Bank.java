package com.leetcode.easy.math;

public class _1716_Calculate_Money_in_Leetcode_Bank {
    //https://leetcode.com/problems/calculate-money-in-leetcode-bank/

    public int totalMoney(int n) {
        int sum = 0;
        int start = 1;
        int i = 0;
        while (n > 0) {
            if (i == 6) {
                sum += start + i;
                i = 0;
                start++;
            } else {
                sum += (start + i);
                i++;
            }
            n--;
        }
        return sum;
    }
}
