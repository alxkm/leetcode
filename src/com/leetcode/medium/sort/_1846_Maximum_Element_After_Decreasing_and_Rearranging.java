package com.leetcode.medium.sort;

import java.util.Arrays;

public class _1846_Maximum_Element_After_Decreasing_and_Rearranging {
    //https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/
    //1846. Maximum Element After Decreasing and Rearranging

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int max = 1;
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) > 1) {
                arr[i] = arr[i - 1] + 1;
            }
            max = Math.max(arr[i], max);
        }
        return max;
    }
}
