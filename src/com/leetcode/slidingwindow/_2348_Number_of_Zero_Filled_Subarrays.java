package com.leetcode.slidingwindow;

public class _2348_Number_of_Zero_Filled_Subarrays {
    //https://leetcode.com/problems/number-of-zero-filled-subarrays/description/
    //2348. Number of Zero-Filled Subarrays

    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        int l = 0, r = 0;

        while (r < nums.length) {
            while (r < nums.length && nums[r] == 0) {
                count += (r - l) + 1;
                r++;
            }
            r++;
            l = r;
        }

        return count;
    }
}
