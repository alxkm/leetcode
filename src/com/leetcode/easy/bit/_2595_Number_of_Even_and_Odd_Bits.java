package com.leetcode.easy.bit;

public class _2595_Number_of_Even_and_Odd_Bits {
    //2595. Number of Even and Odd Bits
    //https://leetcode.com/problems/number-of-even-and-odd-bits/description/

    public int[] evenOddBit(int n) {
        boolean isEven = true;
        int[] evenOdd = new int[2];
        while (n > 0) {
            if (n % 2 == 1) evenOdd[isEven ? 0 : 1]++;
            isEven = !isEven;
            n /= 2;
        }
        return evenOdd;
    }
}
