package com.leetcode.easy.array;

import java.util.Arrays;

public class _3131_Find_the_Integer_Added_to_Array_I {
    //3131. Find the Integer Added to Array I
    //https://leetcode.com/problems/find-the-integer-added-to-array-i

    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        return nums2[0] - nums1[0];
    }
}
