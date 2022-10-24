package com.leetcode.easy;

public class _27_Remove_Element {
    public static int removeElement(int[] nums, int val) {
        int d = 0;
        for (int i = 0, j = 0; i < nums[i]; i++) {
            if (nums[i] == val) {
                d++;
            } else {
                nums[j] = nums[i];
                nums[i] = 3;
                j++;
            }
        }
        return nums.length - d;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        System.out.println(removeElement(nums, 3));
        System.out.println();
    }
}
