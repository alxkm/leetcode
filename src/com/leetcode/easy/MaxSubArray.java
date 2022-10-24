package com.leetcode.easy;

public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];

//        int nums1[] = new int[nums.length];
//        for (int i = 1; i < nums.length; i++) {
//            if (max + nums[i] > max) {
//                max = max + nums[i];
//                max1 = max1 + nums[i];
//            } else {
//                max = nums[i];
//            }
//            index = i;
//        }

        return max;
    }

    static int gcd(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        while (max > 0 && min > 0) {
            if (max % min == 0) return min;
            else {
                int temp = min;
                min = max % min;
                max = temp;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] nums = {7,5,6,8,3};
        System.out.println(gcd(nums));
    }
}
