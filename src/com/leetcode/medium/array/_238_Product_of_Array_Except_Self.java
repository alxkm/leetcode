package com.leetcode.medium.array;

import java.util.Arrays;

public class _238_Product_of_Array_Except_Self {
    //https://leetcode.com/problems/product-of-array-except-self/
    //238. Product of Array Except Self

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

    public int[] productExceptSelf1(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] answ = new int[nums.length];
        prefix[0] = nums[0];
        suffix[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }
        answ[0] = suffix[1];
        answ[nums.length - 1] = prefix[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            answ[i] = prefix[i - 1] * suffix[i + 1];
        }
        return answ;
    }

    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] pr = new int[n + 1];
        int[] sf = new int[n + 1];

        int[] ar = new int[n];
        pr[0] = 1;
        for (int i = 0; i < n; i++) {
            pr[i + 1] = pr[i] * nums[i];
        }
        sf[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            sf[i] = sf[i + 1] * nums[i];
        }

        ar[0] = sf[1];
        ar[n - 1] = pr[n - 1];
        for (int i = 1; i < n - 1; i++) {
            ar[i] = pr[i - 1] * sf[i + 1];
        }
        return ar;
    }

    public static void main(String[] args) {
        int[] a = {4,3,2,1,2};
        System.out.println(Arrays.toString(productExceptSelf2(a)));
    }
}
