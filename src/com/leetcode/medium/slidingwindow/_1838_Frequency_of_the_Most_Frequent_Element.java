package com.leetcode.medium.slidingwindow;

import java.util.Arrays;

public class _1838_Frequency_of_the_Most_Frequent_Element {
    //https://leetcode.com/problems/frequency-of-the-most-frequent-element/
    //1838. Frequency of the Most Frequent Element
    //FOREIGN_SOLUTION
    //TOP

    public int maxFrequency(int[] nums, int k) {
        int max = 1;
        Arrays.sort(nums);
        long totalSum = 0;

        for (int l = 0, r = 0; r < nums.length; r++) {
            totalSum += nums[r];
            while ((long)nums[r]*(r - l + 1) > totalSum + k) {
                totalSum -= nums[l];
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
