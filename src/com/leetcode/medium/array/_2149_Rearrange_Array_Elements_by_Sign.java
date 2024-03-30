package com.leetcode.medium.array;

public class _2149_Rearrange_Array_Elements_by_Sign {
    //2149. Rearrange Array Elements by Sign
    //https://leetcode.com/problems/rearrange-array-elements-by-sign/

    public int[] rearrangeArray(int[] nums) {
        int[] negative = new int[nums.length / 2];
        int[] positive = new int[nums.length / 2];

        for (int i = 0, j = 0, k = 0; i < nums.length; i++) {
            if (nums[i] < 0) negative[j++] = nums[i];
            else positive[k++] = nums[i];
        }

        for (int i = 0, j = 0, k = 0; i < nums.length; i++) {
            nums[i] = positive[j++];
            i++;
            nums[i] = negative[k++];
        }
        return nums;
    }
}
