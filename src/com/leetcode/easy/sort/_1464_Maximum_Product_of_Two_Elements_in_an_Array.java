package com.leetcode.easy.sort;

import java.util.Arrays;

public class _1464_Maximum_Product_of_Two_Elements_in_an_Array {
    //1464. Maximum Product of Two Elements in an Array
    //https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

    public int maxProduct(int[] nums) {
        //int product = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         product = Math.max(product, (nums[i] - 1) * (nums[j] - 1));
        //     }
        // }
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1) ;
    }

    public int maxProduct1(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }
}
