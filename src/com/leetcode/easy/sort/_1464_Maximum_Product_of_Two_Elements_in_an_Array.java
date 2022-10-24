package com.leetcode.easy.sort;

import java.util.Arrays;

public class _1464_Maximum_Product_of_Two_Elements_in_an_Array {
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
}
