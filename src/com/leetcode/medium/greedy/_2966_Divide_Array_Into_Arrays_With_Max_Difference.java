package com.leetcode.medium.greedy;

import java.util.Arrays;

public class _2966_Divide_Array_Into_Arrays_With_Max_Difference {
    //2966. Divide Array Into Arrays With Max Difference
    //https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        if (nums.length % 3 != 0 || nums.length < 3) return new int[][]{};
        int[][] ar = new int[nums.length / 3][3];
        for (int i = 0, j = 0; i <= nums.length - 3; i++, j++) {
            int a = nums[i];
            int b = nums[++i];
            int c = nums[++i];

            if (c - a > k) return new int[][]{};
            ar[j][0] = a;
            ar[j][1] = b;
            ar[j][2] = c;
        }
        return ar;
    }
}
