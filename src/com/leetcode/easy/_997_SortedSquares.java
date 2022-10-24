package com.company;

import java.util.Arrays;

public class _997_SortedSquares {
    static class Solution {
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

        public int[] sortedSquares1(int[] nums) {
            int n=nums.length;
            int[] ans = new int[n];
            int start = 0, end = n - 1;
            for (int index = n - 1; index >= 0; index--) {
                if (Math.abs(nums[start]) > Math.abs(nums[end])) {
                    ans[index] = nums[start] * nums[start];
                    start++;
                } else {
                    ans[index] = nums[end] * nums[end];
                    end--;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {-1};

        int[] result = s.sortedSquares(nums);

        System.out.println(Arrays.toString(result));
    }
}
