package com.leetcode.medium.greedy;

import java.util.Arrays;

public class _2971_Find_Polygon_With_the_Largest_Perimeter {
    //2971. Find Polygon With the Largest Perimeter
    //https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/

    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int[] pf = new int[nums.length];
        pf[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pf[i] = pf[i - 1] + nums[i];
        }
        System.out.println(Arrays.toString(pf));
        System.out.println(Arrays.toString(nums));
        int max = -1;
        for (int i = 2; i < nums.length; i++) {
            System.out.println(pf[i - 1] + " - " + nums[i]);
            if (pf[i] <= nums[i]) {
                max = pf[i];
            }
//            } else if (i != 2 && nums[i] > pf[i - 1]) {
//                max = pf[i - 1];
//            }
        }
        return max;
    }

    public long largestPerimeter1(int[] nums) {
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

    public static void main(String[] args) {
        var sol = new _2971_Find_Polygon_With_the_Largest_Perimeter();
        System.out.println(sol.largestPerimeter(new int[]{1, 12, 1, 2, 5, 50, 3}));
    }
}
