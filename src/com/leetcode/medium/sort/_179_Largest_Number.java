package com.leetcode.medium.sort;

import java.util.Arrays;

public class _179_Largest_Number {
    //https://leetcode.com/problems/largest-number/
    //179. Largest Number

    public String largestNumber(int[] nums) {
        Integer[] nums1 = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[i] = nums[i];
        }
        Arrays.sort(nums1, (x, y) -> (String.valueOf(x) + y).compareTo(String.valueOf(y) + x));

        StringBuilder sb = new StringBuilder();
        for (int i = nums1.length - 1; i >= 0; i--) {
            sb.append(nums1[i]);
        }
        return sb.toString().startsWith("0") ? "0" : sb.toString();
    }
}
