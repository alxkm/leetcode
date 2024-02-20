package com.leetcode.easy.top.array;

public class _896_Monotonic_Array {
    static public boolean isMonotonic1(int[] nums) {
        int a = nums[0];
        boolean increase = true;
        for (int i = 1; i < nums.length; i++) {
            if (a <= nums[i] && increase) {
                a = nums[i];
                continue;
            } else {
                increase = false;
                if (a >= nums[i]) {
                    a = nums[i];
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    static public boolean isMonotonic(int[] nums) {
        int a = nums[0];
        boolean increase = true;
        for (int i = 1; i < nums.length; i++) {
            if (a <= nums[i]) {
                a = nums[i];
                continue;
            }
            increase = false;
        }
        if (increase) return true;
        a = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (a >= nums[i]) {
                a = nums[i];
                continue;
            }
            increase = true;
        }

        return !increase;
    }

    public static void main(String[] args) {
        int[] a = {6,5,4,4};

        System.out.println(isMonotonic(a));
    }
}
