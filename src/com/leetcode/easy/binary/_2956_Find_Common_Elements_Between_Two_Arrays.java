package com.leetcode.easy.binary;

public class _2956_Find_Common_Elements_Between_Two_Arrays {
    //https://leetcode.com/problems/find-common-elements-between-two-arrays/description/
    //2956. Find Common Elements Between Two Arrays

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int first = 0;
        int second = 0;
        boolean[] map1 = new boolean[101];
        boolean[] map2 = new boolean[101];

        for (int n : nums1) {
            map1[n] = true;
        }
        for (int n : nums2) {
            map2[n] = true;
        }
        for (int n : nums1) {
            first += map2[n] ? 1 : 0;
        }
        for (int n : nums2) {
            second += map1[n] ? 1 : 0;
        }
        return new int[] {first, second};
    }
}
