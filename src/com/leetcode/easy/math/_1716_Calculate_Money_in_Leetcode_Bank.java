package com.leetcode.easy.math;

public class _1716_Calculate_Money_in_Leetcode_Bank {
    //1716. Calculate Money in Leetcode Bank
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

    public int totalMoney1(int n) {
        int s = 0;
        for (int i = 0, start = 1; n > 0; n--) {
            s += start + i;
            if (++i == 7) {
                i = 0;
                start++;
            }
        }
        return s;
    }
}
