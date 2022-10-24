package com.company;

public class _88_Merge_Sorted_Array {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
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
    }
}
