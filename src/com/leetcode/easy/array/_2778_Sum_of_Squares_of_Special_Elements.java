package com.leetcode.easy.array;

public class _2778_Sum_of_Squares_of_Special_Elements {
    //2778. Sum of Squares of Special Elements
    //https://leetcode.com/problems/sum-of-squares-of-special-elements/

    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            if (n % (i + 1) == 0) {
                s += nums[i] * nums[i];
            }
        }
        return s;
    }
}
