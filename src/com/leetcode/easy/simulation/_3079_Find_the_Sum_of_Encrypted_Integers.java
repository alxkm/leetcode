package com.leetcode.easy.simulation;

public class _3079_Find_the_Sum_of_Encrypted_Integers {
    //3079. Find the Sum of Encrypted Integers
    //https://leetcode.com/problems/find-the-sum-of-encrypted-integers/description/

    public int sumOfEncryptedInt(int[] nums) {
        int s = 0;
        for (int n: nums) {
            int maxDigit = n % 10;
            int a = n;
            while (n > 0) {
                maxDigit = Math.max(n % 10, maxDigit);
                n /= 10;
            }
            int dec = 1;
            int b = 0;
            while (a > 0) {
                b += dec * maxDigit;
                dec *= 10;
                a /= 10;
            }
            s += b;
        }
        return s;
    }
}
