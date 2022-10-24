package com.company.gold.array;

import java.util.Arrays;

public class _169_Majority_Element {
    static public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        int max = 0;
        int maxSum = 0;

        int prev = nums[0];
        int prevSum = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                prevSum++;
            } else if (nums[i] != prev) {
                if (prevSum > maxSum) {
                    maxSum = prevSum;
                    max = prev;
                }
                prev = nums[i];
                prevSum = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 3};
        System.out.println(majorityElement(a));
    }
}
