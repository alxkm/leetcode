package com.leetcode.easy.math;

public class _2652_Sum_Multiples {
    //https://leetcode.com/problems/sum-multiples/

    public int sumOfMultiples(int n) {
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            if (i % 3 == 0) {
                sum += i;
            } else if (i % 5 == 0) {
                sum += i;
            } else if (i % 7 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
