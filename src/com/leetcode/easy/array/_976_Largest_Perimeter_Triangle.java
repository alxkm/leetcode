package com.leetcode.easy.array;

import java.util.Arrays;

public class _976_Largest_Perimeter_Triangle {
    //976. Largest Perimeter Triangle
    //https://leetcode.com/problems/largest-perimeter-triangle/

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }

        return 0;
    }
}
