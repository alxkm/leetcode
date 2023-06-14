package com.leetcode.medium.array;

import java.util.Arrays;

public class _238_Product_of_Array_Except_Self {
    //https://leetcode.com/problems/product-of-array-except-self/

    static public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] answ = new int[nums.length];
        prefix[0] = nums[0];
        suffix[0] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[nums.length - i - 1];
        }
        answ[0] = suffix[1];
        answ[nums.length - 1] = prefix[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            answ[i] = prefix[i - 1] + suffix[i + 1];
        }
        return answ;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(a)));
    }
}
