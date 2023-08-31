package com.leetcode.top.array;

public class _31_Next_Permutation {
    //https://leetcode.com/problems/next-permutation/
    //FOREIGN_SOLUTION

    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;

        int k = nums.length - 1;

        while (k > 0 && nums[k - 1] >= nums[k]) k--;

        int first = k;
        int last = nums.length - 1;

        while (first < last) {
            int tmp = nums[first];
            nums[first] = nums[last];
            nums[last] = tmp;
            first++;
            last--;
        }

        if (k == 0) return;

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > nums[k - 1]) {
                int tmp = nums[i];
                nums[i] = nums[k - 1];
                nums[k - 1] = tmp;
                break;
            }
        }
    }
}
