package com.leetcode.top.top175;

public class _918_Maximum_Sum_Circular_Subarray {
    //https://leetcode.com/problems/maximum-sum-circular-subarray/
    //918. Maximum Sum Circular Subarray
    //FOREIGN_SOLUTION
    //prefixSum

    //Array
    //Divide and Conquer
    //Dynamic Programming
    //Queue
    //Monotonic Queue

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] rightSum = new int[n];
        rightSum[n - 1] = nums[n - 1];

        for (int i = n - 2, suffixSum = nums[n - 1]; i >= 0; i--) {
            suffixSum += nums[i];
            rightSum[i] = Math.max(suffixSum, rightSum[i + 1]);
        }

        int curMax = 0;
        int maxSum = nums[0];
        for (int i = 0, prefixSum = 0; i < n; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            maxSum = Math.max(maxSum, curMax);

            prefixSum += nums[i];
            if (i + 1 < n) {
                maxSum = Math.max(maxSum, prefixSum + rightSum[i + 1]);
            }
        }

        return maxSum;
    }

    public int maxSubarraySumCircular1(int[] nums) {
        int n = nums.length;
        int[] rightSum = new int[n];
        rightSum[n - 1] = nums[n - 1];

        for (int i = n - 2, suffixSum = nums[n - 1]; i >= 0; i--) {
            suffixSum += nums[i];
            rightSum[i] = Math.max(suffixSum, rightSum[i + 1]);
        }

        int curMax = 0;
        int maxSum = nums[0];
        for (int i = 0, prefixSum = 0; i < n; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            maxSum = Math.max(maxSum, curMax);

            prefixSum += nums[i];
            if (i + 1 < n) {
                maxSum = Math.max(maxSum, prefixSum + rightSum[i + 1]);
            }
        }

        return maxSum;
    }
}
