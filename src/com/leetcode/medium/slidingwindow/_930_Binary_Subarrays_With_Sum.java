package com.leetcode.medium.slidingwindow;

public class _930_Binary_Subarrays_With_Sum {
    //930. Binary Subarrays With Sum
    //https://leetcode.com/problems/binary-subarrays-with-sum/

    public int numSubarraysWithSum(int[] nums, int goal) {
        int counter = 0;
        int s = 0;

        for (int i = 0, j = 0; j < nums.length && i < nums.length;) {
            s += nums[j];
            if (nums[j] == goal) counter++;
            if (s == goal) counter++;

            if (s < goal) {
                s += nums[j];
                j++;
            } else {
                s -= nums[i];
                i++;
            }

        }
        return counter;
    }
}
