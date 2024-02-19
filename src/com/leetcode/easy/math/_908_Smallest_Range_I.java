package com.leetcode.easy.math;

import java.util.Arrays;

public class _908_Smallest_Range_I {
    //https://leetcode.com/problems/smallest-range-i/
    //908. Smallest Range I

    public int smallestRangeI(int[] nums, int k) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();

        if (min == max || max <= k) return 0;

        int minDiff = min + k;

        int maxDiff = max - minDiff;

        if (maxDiff < k) return 0;

        max -= k;

        return max - minDiff;
    }
}
