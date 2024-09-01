package com.leetcode.easy.math;

public class _2566_Maximum_Difference_by_Remapping_a_Digit {
    //2566. Maximum Difference by Remapping a Digit
    //https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/description/

    public int minMaxDifference(int num) {
        String n = Integer.toString(num);
        int max = num;
        int min = num;
        for (int i = 0; i <= 9; i++) {
            max = Math.max(max, Integer.parseInt(n.replaceAll(String.valueOf(i), "9")));
            min = Math.min(min, Integer.parseInt(n.replaceAll(String.valueOf(i), "0")));
        }
        return max - min;
    }
}
