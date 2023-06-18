package com.leetcode.easy.array;

public class _2535_Difference_Between_Element_Sum_and_Digit_Sum_of_an_Array {
    //https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/

    public int differenceOfSum(int[] nums) {
        int sumf = 0;
        int sums = 0;
        for (int i: nums) {
            sumf += i;
        }
        for (int i: nums) {
            var sb = new StringBuilder(Integer.valueOf(i).toString());
            for (char ch: sb.toString().toCharArray()) {
                sums += Character.getNumericValue(ch);
            }
        }
        return sumf - sums;
    }
}
