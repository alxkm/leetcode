package com.leetcode.top.top175.dp;

import java.util.Arrays;

public class _673_Number_of_Longest_Increasing_Subsequence {
    //https://leetcode.com/problems/number-of-longest-increasing-subsequence/
    //673. Number of Longest Increasing Subsequence
    //FOREIGN_SOLUTION
    //TOP
    //LCS

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);

        int lenLIS = 1, result = 1;

        for (int i = nums.length - 1; i > 0; i--) {
            int maxLen = 1;
            int maxCnt = 1;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {

                    int length = dp[j];
                    int count = cnt[j];

                    if (length + 1 > maxLen) {
                        maxLen = length + 1;
                        maxCnt = count;
                    } else if (length + 1 == maxLen) {
                        maxCnt += count;
                    }
                }
            }

            if (maxLen > lenLIS) {
                lenLIS = maxLen;
                result = maxCnt;
            } else if (maxLen == lenLIS) {
                result += maxCnt;
            }
            dp[i] = maxLen;
            cnt[i] = maxCnt;
        }

        return result;
    }
}
