package com.leetcode.medium.sort;

import java.util.Arrays;

public class _2971_Find_Polygon_With_the_Largest_Perimeter {
    //2971. Find Polygon With the Largest Perimeter
    //https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/

    //Sort the array.
    //Use greedy algorithm. If we select an edge as the longest side, it is always better to pick up all the edges with length no longer than this longest edge.
    //Note that the number of edges should not be less than 3.

    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long max = -1;
        long prevSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < prevSum) {
                max = nums[i] + prevSum;
            }
            prevSum += nums[i];
        }
        return max;
    }
}
