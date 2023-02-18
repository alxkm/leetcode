package com.leetcode.top;

public class _152_Maximum_Product_Subarray {
    //https://leetcode.com/problems/maximum-product-subarray/
    //152. Maximum Product Subarray

    public int max(int n1, int n2, int n3) {
        int a = Math.max(n1, n2);
        return Math.max(a, n3);
    }

    public int min(int n1, int n2, int n3) {
        int a = Math.min(n1, n2);
        return Math.min(a, n3);
    }

    public int maxProduct(int[] nums) {
        int max = 1, min = 1, result = nums[0];
        for (int n: nums) {
            if (n == 0) {
                max = 1;
                min = 1;
                result = Math.max(result, n);
            }
            int tmp = max;
            max = max(min * n, max * n, n);
            min = min(min * n, tmp * n, n);
            result = Math.max(max, result);
        }
        return result;
    }
}
