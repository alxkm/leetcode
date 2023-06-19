package com.leetcode.easy.math;

public class _507_Perfect_Number {
    //https://leetcode.com/problems/perfect-number/

    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int sum = 1;
        int i = 2;
        int n =  num / 2;
        while (i <= n) {
            if (num % i == 0) {
                sum += i;
            }
            i++;
        }
        return sum == num;
    }
}
