package com.leetcode.easy.array;

public class _2562_Find_the_Array_Concatenation_Value {
    //2562. Find the Array Concatenation Value
    //https://leetcode.com/problems/find-the-array-concatenation-value/description/

    public long findTheArrayConcVal(int[] nums) {
        long val = 0;
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            if (i == j) {
                val += nums[i];
            } else {
                String s = Integer.valueOf(nums[i]).toString() + Integer.valueOf(nums[j]).toString();
                val += Long.valueOf(s);
            }
        }
        return val;
    }
}
