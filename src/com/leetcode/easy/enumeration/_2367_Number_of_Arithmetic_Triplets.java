package com.leetcode.easy.enumeration;

public class _2367_Number_of_Arithmetic_Triplets {

    static public int arithmeticTriplets(int[] nums, int diff) {
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length; k++) {
                    if ((nums[j] - nums[i]) == diff && (nums[k] - nums[j]) == diff) {
                        counter++;
                    }
                    System.out.println(nums[i] + "   " + nums[j] + "   " + nums[k]);
                }
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        int[] a = {4,5,6,7,8,9};
        System.out.println(arithmeticTriplets(a, 2));
    }
}
