package com.leetcode.K_package;

public class _713_Subarray_Product_Less_Than_K {
    //713. Subarray Product Less Than K
    //https://leetcode.com/problems/subarray-product-less-than-k/description/

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int i = 0, j = 0, s = 1;
        int counter = 0;

        while (j < nums.length) {
            s *= nums[j];
            while (s >= k) {
                s /= nums[i++];
            }
            counter += (j - i + 1);
            j++;
        }
        return counter;
    }
}
