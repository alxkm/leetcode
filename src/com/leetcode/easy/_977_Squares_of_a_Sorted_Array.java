package com.company;

public class _977_Squares_of_a_Sorted_Array {
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] neg1 = new int[nums.length];
            int[] pos = new int[nums.length];
            int n = 0;
            int m = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0) {
                    neg1[n] = nums[i] * nums[i];
                    n++;
                } else {
                    pos[m] = nums[i] * nums[i];
                    m++;
                }
            }

            int[] neg = new int[n];
            int rev = n - 1;
            int ii = 0;
            while (rev >= 0) {
                neg[ii] = neg1[rev];
                rev--;
                ii++;
            }

            int i = 0, j = 0, k = 0;
            int[] a = new int[n + m];
            while (i < m && j < n) {
                if (pos[i] < neg[j]) {
                    a[k] = pos[i];
                    i++;
                } else {
                    a[k] = neg[j];
                    j++;
                }
                k++;
            }

            if (i < m) {
                while (i < m) {
                    a[k] = pos[i];
                    i++;
                    k++;
                }
            } else {
                while (j < n) {
                    a[k] = neg[j];
                    j++;
                    k++;
                }
            }
            return a;
        }
    }
}
