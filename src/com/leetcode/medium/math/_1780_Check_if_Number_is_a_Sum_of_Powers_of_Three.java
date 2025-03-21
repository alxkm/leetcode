package com.leetcode.medium.math;

public class _1780_Check_if_Number_is_a_Sum_of_Powers_of_Three {
    //1780. Check if Number is a Sum of Powers of Three
    //https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/description/?envType=daily-question&envId=2025-03-04

    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) return false;
            n /= 3;
        }
        return true;
    }
}
