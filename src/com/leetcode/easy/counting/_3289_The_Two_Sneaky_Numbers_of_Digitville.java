package com.leetcode.easy.counting;

public class _3289_The_Two_Sneaky_Numbers_of_Digitville {
    //3289. The Two Sneaky Numbers of Digitville
    //https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/description/

    public int[] getSneakyNumbers(int[] nums) {
        int[] count = new int[101];
        for (int n: nums) count[n]++;
        int[] ar = new int[2];
        for (int i = 0, j = 0; i < count.length && j < 2; i++) {
            if (count[i] >= 2) ar[j++] = i;
        }
        return ar;
    }
}
