package com.leetcode.easy.array;

import java.util.Arrays;

public class _3194_Minimum_Average_of_Smallest_and_Largest_Elements {
    //3194. Minimum Average of Smallest and Largest Elements
    //https://leetcode.com/problems/minimum-average-of-smallest-and-largest-elements/description/

    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double min = Integer.MAX_VALUE;
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            min = Math.min(min, (double)((double)(nums[i] + nums[j]) / 2.0));
        }
        return min;
    }
}
