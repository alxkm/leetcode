package com.leetcode.top;

public class _918_Maximum_Sum_Circular_Subarray {
    //https://leetcode.com/problems/maximum-sum-circular-subarray/
    //FOREIGN_SOLUTION

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] rightSum = new int[n];
        rightSum[n - 1] = nums[n - 1];

        for (int i = n - 2, suffixSum = nums[n - 1]; i >= 0; i--) {
            suffixSum += nums[i];
            rightSum[i] = Math.max(suffixSum, rightSum[i + 1]);
        }

        int maxSum = nums[0];
        for (int i = 0, prefixSum = 0, curMax = 0; i < n; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            maxSum = Math.max(maxSum, curMax);

            prefixSum += nums[i];
            if (i + 1 < n) {
                maxSum = Math.max(maxSum, prefixSum + rightSum[i + 1]);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        var solution = new _918_Maximum_Sum_Circular_Subarray();
        int[] a = new int[] {5,-3,5};
        System.out.println(solution.maxSubarraySumCircular(a));
    }
}
