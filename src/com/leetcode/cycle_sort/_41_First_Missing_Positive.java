package com.leetcode.cycle_sort;

public class _41_First_Missing_Positive {
    //41. First Missing Positive
    //https://leetcode.com/problems/first-missing-positive/description/

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length;) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length) {
                i++;
            } else if (nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        int i = 0;
        while (i < nums.length && !(nums[i] - 1 != i || nums[i] > nums.length || nums[i] < 0)) {
            i++;
        }
        return i + 1;
    }

    void swap(int[] nums, int cur, int next) {
        int temp = nums[cur];
        nums[cur] = nums[next];
        nums[next] = temp;
    }
}
