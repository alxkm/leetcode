package com.leetcode.easy.array;

public class _1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] l = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int counter = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) counter++;
            }
            l[i] = counter;
        }
        return l;
    }
}
