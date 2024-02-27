package com.leetcode.easy.top;

import java.util.Arrays;

public class _1005_Maximize_Sum_Of_Array_After_K_Negation {
    //1005. Maximize Sum Of Array After K Negations
    //https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
    //easyTop

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        boolean zero = false;
        int neg = 0;
        for (int n: nums) {
            if (n == 0) zero = true;
            if (n < 0) neg++;
        }

        if (neg == 0) {
            if (k % 2 != 0) {
                nums[0] *= -1;
            }
        } else {
            for (int i = 0; i < nums.length && nums[i] <= 0 && k > 0; i++, k--) {
                nums[i] *= -1;
            }
            if (!zero && k > 0 && k % 2 != 0) {
                Arrays.sort(nums);
                nums[0] *= -1;
            }
        }

        int s = 0;
        for (int i = 0; i < nums.length; i++)  {
            s += nums[i];
        }
        return s;
    }

    public int largestSumAfterKNegations1(int[] nums, int k) {
        Arrays.sort(nums);
        boolean zero = false;
        int neg = 0;
        for (int n: nums) {
            if (n == 0) zero = true;
            if (n < 0) neg++;
        }

        if (neg == 0) {
            if (k % 2 != 0) {
                nums[0] *= -1;
            }
        } else {
            for (int i = 0; i < nums.length && nums[i] <= 0 && k > 0; i++, k--) {
                nums[i] *= -1;
            }
            if (!zero && k > 0 && k % 2 != 0) {
                int index = 0;
                int min = nums[0];
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] < min) {
                        min = nums[i];
                        index = i;
                    }
                }
                nums[index] *= -1;
            }
        }

        int s = 0;
        for (int i = 0; i < nums.length; i++)  {
            s += nums[i];
        }
        return s;
    }

    //foreign solution

    public int largestSumAfterKNegations2(int[] nums, int k) {
        int[] numbers = new int[201];
        int sum = 0;
        int maxAbs = 0;
        for (int n: nums) {
            maxAbs = Math.max(maxAbs, Math.abs(n));
            numbers[100 + n]++;
            sum += n;
        }
        if (maxAbs == 0) {
            return 0;
        }
        while (k-- != 0) {
            int i = 100 - maxAbs;
            while (numbers[i] == 0) {
                i++;
            }
            numbers[i]--;
            numbers[200 - i]++;
            sum -= 2 * (i - 100);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 2, 3};
        int k1 = 1;

        int[] nums2 = {3, -1, 0, 2};
        int k2 = 3;

        int[] nums3 = {2, -3, -1, 5, -4};
        int k3 = 2;

        int[] nums4 = {-100, -1, 0, 2, 1, 2};
        int k4 = 4;
    }
}
