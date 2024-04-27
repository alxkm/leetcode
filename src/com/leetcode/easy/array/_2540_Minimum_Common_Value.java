package com.leetcode.easy.array;

public class _2540_Minimum_Common_Value {
    //2540. Minimum Common Value
    //https://leetcode.com/problems/minimum-common-value/description/

    public int getCommon(int[] nums1, int[] nums2) {
        int l1 = 0, l2 = 0;
        while (l1 < nums1.length && l2 < nums2.length) {
            if (nums1[l1] == nums2[l2]) return nums1[l1];
            if (nums1[l1] < nums2[l2]) l1++;
            else if (nums1[l1] > nums2[l2]) l2++;
        }
        return -1;
    }

    public int getCommon1(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) return nums1[i];
            if (nums1[i] > nums2[j]) j++;
            else i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,6}, nums2 = {2,3,4,5};
        var sol = new _2540_Minimum_Common_Value();
        System.out.println(sol.getCommon(nums1, nums2));
    }
}
