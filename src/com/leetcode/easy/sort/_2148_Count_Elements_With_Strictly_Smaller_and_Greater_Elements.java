package com.leetcode.easy.sort;

public class _2148_Count_Elements_With_Strictly_Smaller_and_Greater_Elements {
    public int countElements(int[] nums) {
        int counter = 0;
        int min = nums[0];
        int max = nums[0];
        for (int n : nums) {
            min = Math.min(n, min);
            max = Math.max(n, max);
        }
        for (int n : nums) {
            if (n != min && n != max) {
                counter++;
            }
        }
        return counter;
    }
}
