package com.leetcode.easy.array;

public class _2553_Separate_the_Digits_in_an_Array {
    //https://leetcode.com/problems/separate-the-digits-in-an-array/

    public int[] separateDigits(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i: nums) {
            sb.append(i);
        }
        int[] n = new int[sb.length()];
        char[] str = sb.toString().toCharArray();
        for (int i = 0; i < sb.length(); i++) {
            n[i] = str[i] - '0';
        }
        return n;
    }
}
