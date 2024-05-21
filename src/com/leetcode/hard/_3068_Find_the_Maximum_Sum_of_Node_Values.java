package com.leetcode.hard;

import java.util.Arrays;

public class _3068_Find_the_Maximum_Sum_of_Node_Values {
    //https://leetcode.com/problems/find-the-maximum-sum-of-node-values/description/
    //3068. Find the Maximum Sum of Node Values

    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        int[] delta = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            delta[i] = (nums[i] ^ k) - nums[i];
            sum += nums[i];
        }
        Arrays.sort(delta);

        for (int i = 0; i < n / 2; i++) {
            int t = delta[i];
            delta[i] = delta[n - 1 - i];
            delta[n - 1 - i] = t;
        }

        for (int i = 0; i < n; i += 2) {
            if (i == n - 1) break;
            long pathDelta = delta[i] + delta[i + 1];
            if (pathDelta <= 0) break;
            sum += pathDelta;
        }
        return sum;
    }
}
