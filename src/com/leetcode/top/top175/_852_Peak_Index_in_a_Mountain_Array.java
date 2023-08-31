package com.leetcode.top.top175;

public class _852_Peak_Index_in_a_Mountain_Array {
    //https://leetcode.com/problems/peak-index-in-a-mountain-array/
    //FOREIGN_SOLUTION

    public int peakIndexInMountainArray(int[] arr) {

        if (arr.length == 1) return arr[0];
        if (arr[0] > arr[1]) return arr[0];

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int m = left + (right - left) / 2;
            if (arr[m] < arr[m + 1]) {
                left = m + 1;
            } else {
                right = m;
            }
        }
        return right;
    }
}
