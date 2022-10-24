package com.leetcode.easy.sort;

import java.util.Arrays;

public class _2164_Sort_Even_and_Odd_Indices_Independently {
     static public int[] sortEvenOdd(int[] nums) {
         int n = 0;
         int m = 0;
         for (int i = 0; i < nums.length; i++) {
             if (i % 2 == 0) {
                 n++;
             } else {
                 m++;
             }
         }
         int[] a = new int[n];
         int[] b = new int[m];
         for (int k = 0, i = 0, j = 0; k < nums.length; k++) {
             if (k % 2 == 0) {
                 a[i++] = nums[k];
             } else {
                 b[j++] = nums[k];
             }
         }
         Arrays.sort(a);
         Arrays.sort(b);
         for (int k = 0, i = 0; k < nums.length; k++) {
             if (k % 2 == 0) {
                 nums[k] = a[i++];
             } else {
                 nums[k] = b[--m];
             }
         }
         return nums;
    }

    public static void main(String[] args) {
        //int[] a = {6,45,16,41,26,33,32,31,34,31,36,27,36,15,44,15,46,9};
        int[] a = {16,31,38,24,15,38,45,13,23,38,26,44,21,25,33,29,11,42};

        System.out.println(Arrays.toString(sortEvenOdd(a)));
    }
}
