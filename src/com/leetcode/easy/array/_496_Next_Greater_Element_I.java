package com.leetcode.easy.array;

public class _496_Next_Greater_Element_I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            boolean start = false;
            int max = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    start = true;
                    continue;
                }
                if (start && nums1[i] < nums2[j]) {
                    nums1[i] = nums2[j];
                    break;
                }
            }
            if (nums1[i] == max) nums1[i] = -1;
        }
        return nums1;
    }
}
