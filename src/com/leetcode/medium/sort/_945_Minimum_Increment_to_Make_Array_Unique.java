package com.leetcode.medium.sort;

import com.leetcode.ArrayUtil;

import java.util.Arrays;

public class _945_Minimum_Increment_to_Make_Array_Unique {
    //945. Minimum Increment to Make Array Unique
    //https://leetcode.com/problems/minimum-increment-to-make-array-unique/description/

    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int counter = 0;
        boolean[] used = new boolean[1000000];
        for(int n: nums) used[n] = true;
        int prev = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && nums[i] != -1) {
                if (prev > nums[i]) {
                    counter += prev - nums[i];
                } else {
                    prev = nums[i];
                }
                nums[i - 1] = -1;
                while (used[prev]) {
                    prev++;
                    counter++;
                }
                used[prev] = true;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        var sol = new _945_Minimum_Increment_to_Make_Array_Unique();
        //System.out.println(sol.minIncrementForUnique(ArrayUtil.of(3, 2, 1, 2, 1, 7)));
        System.out.println(sol.minIncrementForUnique(ArrayUtil.of(14,4,5,14,13,14,10,17,2,12,2,14,7,13,14,13,4,16,4,10)));
    }
}
