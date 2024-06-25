package com.leetcode.hard;

public class _995_Minimum_Number_of_K_Consecutive_Bit_Flips {
    //995. Minimum Number of K Consecutive Bit Flips
    //https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/description/

    public int minKBitFlips(int[] nums, int k) {
        int curWindowFlips = 0;
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - k >= 0 && nums[i - k] == 2) {
                curWindowFlips--;
            }
            if ((curWindowFlips + nums[i]) % 2  == 0) {
                if (i + k > nums.length) {
                    return -1;
                }

                nums[i] = 2;
                curWindowFlips++;
                counter++;
            }
        }
        return counter;
    }
}
