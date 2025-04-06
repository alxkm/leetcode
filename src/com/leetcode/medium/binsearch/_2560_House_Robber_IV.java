package com.leetcode.medium.binsearch;

import java.util.Arrays;

public class _2560_House_Robber_IV {
    //2560. House Robber IV
    //https://leetcode.com/problems/house-robber-iv/description/?envType=daily-question&envId=2025-03-15

    public int minCapability(int[] nums, int k) {
        int l = Arrays.stream(nums).min().getAsInt();
        int r = Arrays.stream(nums).max().getAsInt();

        int res = 0;
        while (l <= r) {
            int m = (l + r) / 2;

            if (isValid(nums, k, m)) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }

    boolean isValid(int[] nums, int k, int cap) {
        int i = 0;
        int count = 0;
        while (i < nums.length) {
            if (nums[i] <= cap) {
                i += 2;
                count += 1;
            } else {
                i += 1;
            }

            if (count == k) break;
        }
        return count == k;
    }
}
