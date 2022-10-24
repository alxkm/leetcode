package com.leetcode.easy;

import java.util.Arrays;

public class MergeTwoArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] a = new int[n + m];

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                a[k] = nums1[i];
                i++;
            } else {
                a[k] = nums2[j];
                j++;
            }
            k++;
        }

        if (i < m) {
            while (i < m) {
                a[k] = nums1[i];
                i++;
                k++;
            }
        } else if (j < n) {
            while (j < n) {
                a[k] = nums2[j];
                j++;
                k++;
            }
        }

        for (int i1 = 0; i1 < k; i1++) {
            nums1[i1] = a[i1];
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int l = m - 1;
        int r = n - 1;
        for (int i = m + n - 1; i >= 0 && r >= 0; i--) {
            nums1[i] = l < 0 || nums1[l] < nums2[r] ? nums2[r--] : nums1[l--];
        }
    }

    public int lengthOfLastWord(String s) {
        s.trim();
        if (s.length() == 1) return 1;
        if (s.indexOf(" ") == -1) return s.length();
        return s.substring(s.lastIndexOf(" "), s.length()).length();
    }

    public static void main(String[] args) {

//        int[] nums1 = {1,2,3,0,0,0};
//        int m = 3;
//        int[] nums2 = {2,5,6};
//        int n = 3;

        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;

        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }
}
