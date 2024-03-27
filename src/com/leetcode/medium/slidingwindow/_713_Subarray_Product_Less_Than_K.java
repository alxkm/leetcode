package com.leetcode.medium.slidingwindow;

public class _713_Subarray_Product_Less_Than_K {
    //713. Subarray Product Less Than K
    //https://leetcode.com/problems/subarray-product-less-than-k/

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

    public static void main(String[] args) {
        var sol = new _713_Subarray_Product_Less_Than_K();
        //System.out.println(sol.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
        System.out.println(sol.numSubarrayProductLessThanK(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19));
    }
}
