package com.leetcode.medium.priorityqueue;

public class _2762_Continuous_Subarrays {
    //2762. Continuous Subarrays
    //https://leetcode.com/problems/continuous-subarrays/description/

    public long continuousSubarrays(int[] nums) {
        long total = 0;
        int min = nums[0], max = nums[0];

        for (int i = 0, j = 0; j < nums.length; j++) {
            min = Math.min(min, nums[j]);
            max = Math.max(max, nums[j]);

            while (Math.abs(max - min) > 2) {
                if (nums[i] == min) {
                    min = nums[i + 1];
                    for (int k = i + 1; k <= j; k++) {
                        min = Math.min(min, nums[k]);
                    }
                }
                if (nums[i] == max) {
                    max = nums[i + 1];
                    for (int k = i + 1; k <= j; k++) {
                        max = Math.max(max, nums[k]);
                    }
                }
                i++;
            }

            total += j - i + 1;
        }

        return total;
    }
}
