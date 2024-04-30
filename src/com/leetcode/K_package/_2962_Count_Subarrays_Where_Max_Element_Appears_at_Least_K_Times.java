package com.leetcode.K_package;

public class _2962_Count_Subarrays_Where_Max_Element_Appears_at_Least_K_Times {
    //2962. Count Subarrays Where Max Element Appears at Least K Times
    //https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/

    public long countSubarrays(int[] nums, int k) {
        int max = -1;
        for (int n: nums) max = Math.max(max, n);
        int maxElementsInWindow = 0;
        long counter = 0;

        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] == max) {
                maxElementsInWindow++;
            }

            while (maxElementsInWindow == k) {
                if (nums[i] == max) {
                    maxElementsInWindow--;
                }
                i++;
            }
            counter += i;
        }

        return counter;
    }
}
