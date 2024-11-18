package com.leetcode.medium.binary;

public class _1829_Maximum_XOR_for_Each_Query {
    //1829. Maximum XOR for Each Query
    //https://leetcode.com/problems/maximum-xor-for-each-query/?envType=daily-question&envId=2024-11-08

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = 0;
        for (int n: nums) xor ^= n;

        int[] answ = new int[nums.length];
        int mask = (1 << maximumBit) - 1;
        for (int i = nums.length - 1, j = 0; i >= 0; i--, j++) {
            answ[j] = xor ^ mask;
            xor ^= nums[i];
        }
        return answ;
    }
}
