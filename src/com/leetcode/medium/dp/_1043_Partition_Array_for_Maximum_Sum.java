package com.leetcode.medium.dp;

public class _1043_Partition_Array_for_Maximum_Sum {
    //https://leetcode.com/problems/partition-array-for-maximum-sum/
    //1043. Partition Array for Maximum Sum

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int max = 0;
            int localMax = 0;
            for (int j = 1; i - j >= 0 && j <= k; j++) {
                localMax = Math.max(localMax, arr[i - j]);
                max = Math.max(max, dp[i - j] + localMax * j);
            }
            dp[i] = max;
        }

        return dp[n];
    }
}
