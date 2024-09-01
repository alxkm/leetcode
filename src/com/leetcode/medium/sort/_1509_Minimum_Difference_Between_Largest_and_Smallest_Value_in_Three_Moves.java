package com.leetcode.medium.sort;

import com.leetcode.ArrayUtil;

import java.util.Arrays;

public class _1509_Minimum_Difference_Between_Largest_and_Smallest_Value_in_Three_Moves {
    //1509. Minimum Difference Between Largest and Smallest Value in Three Moves
    //https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/?envType=daily-question&envId=2024-07-03
    //FOREIGN_SOLUTION

    public int minDifference(int[] nums) {
        int numsSize = nums.length;

        // If the array has 4 or fewer elements, return 0
        if (numsSize <= 4) return 0;

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        // Four scenarios to compute the minimum difference
        for (int left = 0, right = numsSize - 4; left < 4; left++, right++) {
            minDiff = Math.min(minDiff, nums[right] - nums[left]);
        }

        return minDiff;
    }

    public static void main(String[] args) {
        var sol = new _1509_Minimum_Difference_Between_Largest_and_Smallest_Value_in_Three_Moves();
        //System.out.println(sol.minDifference(ArrayUtil.of(1, 5, 6, 14, 15)));
        System.out.println(sol.minDifference(ArrayUtil.of(82,81,95,75,20)));
    }
}
