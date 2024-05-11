package com.leetcode.medium.slidingwindow;

import com.leetcode.ArrayUtil;

import java.util.Arrays;

public class _2962_Count_Subarrays_Where_Max_Element_Appears_at_Least_K_Times {
    //2962. Count Subarrays Where Max Element Appears at Least K Times
    //https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/

    public long countSubarrays(int[] nums, int k) {
        int max = nums[0];
        for (int n: nums) max = Math.max(max, n);
        int maxElementsInWindow = 0;
        long counter = 0;

        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] == max) {
                maxElementsInWindow++;
            }

            while (maxElementsInWindow >= k && i <= j) {
                if (nums[i] == max) {
                    maxElementsInWindow--;
                }
                i++;
            }
            counter += i;
        }

        return counter;
    }

    public long countSubarrays1(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int maxElementsInWindow = 0;
        long counter = 0;

        for (int start = 0, end = 0; end < nums.length; end++) {
            if (nums[end] == max) {
                maxElementsInWindow++;
            }

            while (k == maxElementsInWindow) {
                if (nums[start] == max) {
                    maxElementsInWindow--;
                }
                start++;
            }
            counter += start;
        }

        return counter;
    }

    public static void main(String[] args) {
        var sol = new _2962_Count_Subarrays_Where_Max_Element_Appears_at_Least_K_Times();
        System.out.println(sol.countSubarrays(ArrayUtil.of(1, 3, 2, 3, 3), 2));
    }
}
