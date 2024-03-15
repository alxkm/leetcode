package com.leetcode.easy.enumeration;

public class _2970_Count_the_Number_of_Incremovable_Subarrays_I {
    //2970. Count the Number of Incremovable Subarrays I
    //https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i/

    public int incremovableSubarrayCount(int[] nums) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {

                boolean increasing = true;
                int prev = Integer.MAX_VALUE;

                for (int k = 0; k < i; k++) {
                    if (prev == Integer.MAX_VALUE) {
                        prev = nums[k];
                    } else if (prev < nums[k]) {
                        prev = nums[k];
                    } else {
                        increasing = false;
                        break;
                    }
                }

                for (int k = j + 1; k < nums.length; k++) {
                    if (prev == Integer.MAX_VALUE) {
                        prev = nums[k];
                    } else if (prev < nums[k]) {
                        prev = nums[k];
                    } else {
                        increasing = false;
                        break;
                    }
                }

                if (increasing) counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        var sol = new _2970_Count_the_Number_of_Incremovable_Subarrays_I();
        //System.out.println(sol.incremovableSubarrayCount(new int[]{1, 2, 3, 4}));
        System.out.println(sol.incremovableSubarrayCount(new int[]{6,5,7,8}));
    }

}