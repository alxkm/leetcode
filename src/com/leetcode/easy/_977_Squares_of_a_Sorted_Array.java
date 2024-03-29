package com.leetcode.easy;

import java.util.Arrays;

public class _977_Squares_of_a_Sorted_Array {
    //977. Squares of a Sorted Array
    //https://leetcode.com/problems/squares-of-a-sorted-array/
    //easy_top

    public int[] sortedSquares(int[] nums) {
        int[] neg1 = new int[nums.length];
        int[] pos = new int[nums.length];
        int n = 0;
        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                neg1[n] = nums[i] * nums[i];
                n++;
            } else {
                pos[m] = nums[i] * nums[i];
                m++;
            }
        }

        int[] neg = new int[n];
        int rev = n - 1;
        int ii = 0;
        while (rev >= 0) {
            neg[ii] = neg1[rev];
            rev--;
            ii++;
        }

        int i = 0, j = 0, k = 0;
        int[] a = new int[n + m];
        while (i < m && j < n) {
            if (pos[i] < neg[j]) {
                a[k] = pos[i];
                i++;
            } else {
                a[k] = neg[j];
                j++;
            }
            k++;
        }

        if (i < m) {
            while (i < m) {
                a[k] = pos[i];
                i++;
                k++;
            }
        } else {
            while (j < n) {
                a[k] = neg[j];
                j++;
                k++;
            }
        }
        return a;
    }

    public int[] sortedSquares1(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] n = new int[nums.length];
        int i = r;
        while (i >= 0) {
            if (l == r) {
                n[i] = nums[l] * nums[l];
            } else if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                n[i] = nums[l] * nums[l];
                l++;
            } else if (Math.abs(nums[l]) < Math.abs(nums[r])) {
                n[i] = nums[r] * nums[r];
                r--;
            } else if (Math.abs(nums[l]) == Math.abs(nums[r])) {
                n[i] = nums[r] * nums[r];
                i--;
                r--;
                n[i] = nums[l] * nums[l];
                l++;
            }
            i--;
        }
        return n;
    }

    public int[] sortedSquares2(int[] nums) {
        int[] ar = new int[nums.length];
        for (int i = 0; i < nums.length; i++) nums[i] *= nums[i];

        for (int i = 0, j = nums.length - 1, r = nums.length - 1, l = 0; i <= j; ) {
            if (i == j) {
                ar[r] = nums[i];
                break;
            }
            if (nums[i] > nums[j]) {
                ar[r] = nums[i];
                r--;
                i++;
            } else if (nums[i] == nums[j]) {
                ar[r] = nums[i];
                r--;
                ar[r] = nums[j];
                r--;
                i++;
                j--;
            } else if (nums[i] < nums[j]) {
                ar[r] = nums[j];
                j--;
                r--;
            }
        }
        return ar;
    }

    public static void main(String[] args) {
       var sol = new _977_Squares_of_a_Sorted_Array();

        //System.out.println(sol.sortedSquares2(new int [] {-7,-3,2,3,11}));
        System.out.println(sol.sortedSquares2(new int [] {-4,-1,0,3,10}));
    }
}
